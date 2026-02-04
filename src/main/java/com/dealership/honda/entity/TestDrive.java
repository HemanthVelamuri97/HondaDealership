package com.dealership.honda.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long saleslead_id;

    private Long vehicle_id;

    @Column(name ="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    private String status;

    private String notes;
}
