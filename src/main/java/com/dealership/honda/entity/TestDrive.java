package com.dealership.honda.entity;

import com.dealership.honda.enums.TestDriveStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "saleslead_id")
    private SalesLead salesLeadId;

    @ManyToOne
    @JoinColumn(name  = "vehicle_id")
    private Vehicle vehicleId;

    @Column(name ="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    private TestDriveStatus testDriveStatus;

    private String notes;
}
