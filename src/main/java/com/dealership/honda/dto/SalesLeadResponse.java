package com.dealership.honda.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalesLeadResponse {
    private Long id;
    private Long customerId;
    private Long vehicleId;
    private Long assignedTo;
    private String source;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
}
