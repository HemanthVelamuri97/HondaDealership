package com.dealership.honda.repository;

import com.dealership.honda.entity.SalesLead;
import com.dealership.honda.entity.TestDrive;
import com.dealership.honda.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TestDriveRepo extends JpaRepository<TestDrive,Long> {

    List<TestDrive> findBySalesLeadId(SalesLead salesLeadId);

    List<TestDrive> findByVehicleId(Vehicle VehicleId);

    List<TestDrive> findByCreatedAt(LocalDateTime createdAt);

}
