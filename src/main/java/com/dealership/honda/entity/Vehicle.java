package com.dealership.honda.entity;

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

    private String model; //ENUM

    private String trim; //ENUM

    private String year;

    private String price;

    private String mileage;

    private String exterior_color; //ENUM

    private String status; //ENUM
}
