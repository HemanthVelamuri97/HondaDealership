package com.dealership.honda.repository;

import com.dealership.honda.entity.Customer;
import com.dealership.honda.entity.SalesLead;
import com.dealership.honda.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesLeadRepo extends JpaRepository<SalesLead,Long> {

    List<SalesLead> findByCustomerId(Customer customerId);

    List<SalesLead> findByVehicleId(Vehicle vehicle);
}
