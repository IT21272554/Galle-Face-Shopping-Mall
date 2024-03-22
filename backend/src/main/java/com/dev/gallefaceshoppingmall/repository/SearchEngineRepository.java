package com.dev.gallefaceshoppingmall.repository;

import java.util.List;

import com.dev.gallefaceshoppingmall.entity.Item;

public interface SearchEngineRepository {

    List<Item> searchItems(String query);
    List<Item> searchItemsByCategory(String category);
    List<Item> searchItemsInCategory(String query, String category);
}
