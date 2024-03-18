package com.dev.gallefaceshoppingmall.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("searchHistory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistory {

    @Id
    private String _id;
    private String keyword;
    private String customerID;
}
