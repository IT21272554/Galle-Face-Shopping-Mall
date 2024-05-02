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
@Document(collection = "slots")
public class Slot {

    @Id
    private String _id;
    private String historyId;
    private String slotNumber;
    private String vehicleType;
    @JsonProperty("isBooked")
    private boolean isBooked;
}