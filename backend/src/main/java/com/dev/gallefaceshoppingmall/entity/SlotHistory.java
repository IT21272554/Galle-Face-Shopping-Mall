package com.dev.gallefaceshoppingmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "slotHistory")
public class SlotHistory {

    @Id
    private String _id;
    private String slotNumber;
    private String name;
    private String nic;
    private String vehicleNumber;
    private String vehicleType;
    private String date;
    private String checkInTime;
    private String checkOutTime;
    private float payment;
}