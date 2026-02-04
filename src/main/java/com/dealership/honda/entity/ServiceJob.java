package com.dealership.honda.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class ServiceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;

    private Long vehicle_id;

    private String service_type;

    private String status;

    private int estimate;

    private String notes;

    @Column(name="opened_at", insertable = false, updatable = false)
    private LocalDateTime openedAt;
}
