package com.dealership.honda.entity;

import com.dealership.honda.enums.ExteriorColor;
import com.dealership.honda.enums.Model;
import com.dealership.honda.enums.Trim;
import com.dealership.honda.enums.VehicleStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;

    private String make;

    private Model model; //ENUM

    private Trim trim; //ENUM

    private String year;

    private String price;

    private String mileage;

    private ExteriorColor exterior_color; //ENUM

    private VehicleStatus status; //ENUM
}
