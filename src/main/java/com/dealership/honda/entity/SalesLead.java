package com.dealership.honda.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "salesLead")
public class SalesLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private Employee assignedTo;
    //ENUM
    @Enumerated
    private String source;
    //ENUM
    private String status;

    private String notes;
}
