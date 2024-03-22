package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.repository.ItemRepository;

@Service
public class SearchHistoryService{

    @Autowired
    ItemRepository repo;

    public void saveOrUpdate(String id) {
        // Retrieve the item by id
        Item existingItem = repo.findById(id).orElse(null);
        
        if (existingItem != null) {
            // Increment the view count
            int count = existingItem.getViewCount();
            count++;
            existingItem.setViewCount(count);
            
            // Save the updated item
            repo.save(existingItem);
        }
    }
    
}
