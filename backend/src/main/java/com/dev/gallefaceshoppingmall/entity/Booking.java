package com.dev.gallefaceshoppingmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class Booking {

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
    private String payment;
}