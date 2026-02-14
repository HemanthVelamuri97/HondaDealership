package com.dealership.honda.entity;

import com.dealership.honda.enums.SalesLeadSource;
import com.dealership.honda.enums.SalesLeadStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "sales_lead")
public class SalesLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private Employee assignedTo;

    @Enumerated(EnumType.STRING)
    private SalesLeadSource source;

    @Enumerated(EnumType.STRING)
    private SalesLeadStatus status;

    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
