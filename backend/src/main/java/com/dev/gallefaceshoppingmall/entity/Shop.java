package com.dev.gallefaceshoppingmall.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    private String _id;
    private String name;
    private String logoImage;
    private String description;
    private String category;
    private String ownerName;
    private String contactNumber;
    private String email;
    private int floorNumber;
    private String openingTime;
    private String closingTime;
    
    
}
