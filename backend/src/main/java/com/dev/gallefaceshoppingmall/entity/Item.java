package com.dev.gallefaceshoppingmall.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private String _id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private String shopId;
    private boolean isInStock = true;
    private String[] thumbnail = new String[4];
    
}
