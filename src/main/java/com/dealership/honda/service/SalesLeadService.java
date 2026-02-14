package com.dealership.honda.service;

import com.dealership.honda.dto.SalesLeadRequest;
import com.dealership.honda.dto.SalesLeadResponse;
import com.dealership.honda.entity.Customer;
import com.dealership.honda.entity.Employee;
import com.dealership.honda.entity.SalesLead;
import com.dealership.honda.entity.Vehicle;
import com.dealership.honda.enums.SalesLeadSource;
import com.dealership.honda.enums.SalesLeadStatus;
import com.dealership.honda.repository.*;
//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SalesLeadService {

    private final SalesLeadRepo salesLeadRepo;
    private final EmployeeRepo employeeRepo;
    private final CustomerRepo customerRepo;
    private final ServiceJobRepo serviceJobRepo;
    private final VehicleRepo vehicleRepo;
    private final TestDriveRepo testDriveRepo;

    public SalesLeadService(SalesLeadRepo salesLeadRepo, EmployeeRepo employeeRepo, CustomerRepo customerRepo, ServiceJobRepo serviceJobRepo, VehicleRepo vehicleRepo, TestDriveRepo testDriveRepo) {
        this.salesLeadRepo = salesLeadRepo;
        this.employeeRepo = employeeRepo;
        this.customerRepo = customerRepo;
        this.serviceJobRepo = serviceJobRepo;
        this.vehicleRepo = vehicleRepo;
        this.testDriveRepo = testDriveRepo;
    }

    public SalesLeadResponse createLead(SalesLeadRequest request) {
        Customer customer = customerRepo.findById(request.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found: " + request.getCustomerId()));
        Vehicle vehicle = null;
        if (request.getVehicleId() != null) {
            vehicle = vehicleRepo.findById(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found: " + request.getVehicleId()));
        }
        Employee assignedTo = null;
        if (request.getAssignedTo() != null) {
            assignedTo = employeeRepo.findById(request.getAssignedTo()).orElseThrow(() -> new RuntimeException("Employee not found: " + request.getAssignedTo()));
        }

        SalesLead lead = new SalesLead();
        lead.setCustomer(customer);
        lead.setVehicle(vehicle);
        lead.setAssignedTo(assignedTo);
        lead.setSource(SalesLeadSource.valueOf(request.getSource()));
        lead.setStatus(SalesLeadStatus.valueOf(request.getStatus()));
        lead.setNotes(request.getNotes());

        SalesLead saved = salesLeadRepo.save(lead);
        return toResponse(saved);
    }
    @Transactional(readOnly = true)
    public SalesLeadResponse getLeadById(Long id) {
        SalesLead lead = salesLeadRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SalesLead not found: " + id));
        return toResponse(lead);
    }

    // ---------------- GET ALL LEADS ----------------
    @Transactional(readOnly = true)
    public List<SalesLeadResponse> getAllLeads() {
        return salesLeadRepo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ---------------- GET LEADS BY VEHICLE ID ----------------
    @Transactional(readOnly = true)
    public List<SalesLeadResponse> getLeadsByVehicleId(Long vehicleId) {
        return salesLeadRepo.findByVehicleId(vehicleId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ---------------- MAPPER ----------------
    private SalesLeadResponse toResponse(SalesLead lead) {
        SalesLeadResponse response = new SalesLeadResponse();
        response.setId(lead.getId());
        response.setCustomerId(lead.getCustomer() != null ? lead.getCustomer().getId() : null);
        response.setVehicleId(lead.getVehicle() != null ? lead.getVehicle().getId() : null);
        response.setAssignedTo(lead.getAssignedTo() != null ? lead.getAssignedTo().getId() : null);
        response.setSource(lead.getSource() != null ? lead.getSource().name() : null);
        response.setStatus(lead.getStatus() != null ? lead.getStatus().name() : null);
        response.setNotes(lead.getNotes());
        response.setCreatedAt(lead.getCreatedAt());
        return response;
    }
}
