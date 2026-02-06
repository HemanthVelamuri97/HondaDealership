package com.dealership.honda.entity;

import com.dealership.honda.enums.ServiceJobStatus;
import com.dealership.honda.enums.ServiceType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class ServiceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicleId;

    private ServiceType service_type;

    private ServiceJobStatus status;

    private int estimate;

    private String notes;

    @Column(name="opened_at", insertable = false, updatable = false)
    private LocalDateTime openedAt;
}
