package com.dealership.honda.entity;

import com.dealership.honda.enums.SalesLeadSource;
import com.dealership.honda.enums.SalesLeadStatus;
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
    private Vehicle vehicleId;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private Employee assignedTo;
    //ENUM
    @Enumerated
    private SalesLeadSource source;
    //ENUM
    private SalesLeadStatus status;

    private String notes;
}
