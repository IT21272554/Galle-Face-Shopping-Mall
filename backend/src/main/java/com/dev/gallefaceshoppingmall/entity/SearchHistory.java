package com.dev.gallefaceshoppingmall.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("searchHistory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchHistory {

    @Id
    private String _id;
    private String itemID;
    private String customerID;
    private int viewCount;
}
