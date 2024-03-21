package com.dev.gallefaceshoppingmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@Document(collection = "parking_details")
public class ParkingDetails {

    @Id
    private String id;
    private int slotNumber;
    private String vehicleNumber;
    private String vehicleType;
}
