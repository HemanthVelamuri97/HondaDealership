package com.dealership.honda.repository;

import com.dealership.honda.entity.Customer;
import com.dealership.honda.entity.ServiceJob;
import com.dealership.honda.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceJobRepo extends JpaRepository {

    List<ServiceJob> findByCustomerID(Customer customerId);

    List<ServiceJob> findByVehicleId(Vehicle vehicleId);
}
