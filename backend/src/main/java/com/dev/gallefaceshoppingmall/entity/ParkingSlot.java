package com.dev.gallefaceshoppingmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ParkingSlot {

    @Id
    private String id;
    private int slotNumber;
    private boolean occupied;
    private String vehicleNumber;
    private VehicleType vehicleType;
}
