package com.dealership.honda.dto;

import lombok.Data;

@Data
public class SalesLeadRequest {
    private Long customerId;
    private Long vehicleId;
    private Long assignedTo;
    private String source;
    private String status;
    private String notes;
}
