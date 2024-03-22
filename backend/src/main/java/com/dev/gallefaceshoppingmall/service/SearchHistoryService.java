package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.SearchHistory;
import com.dev.gallefaceshoppingmall.repository.SearchHistoryRepository;

@Service
public class SearchHistoryService{

    @Autowired
    SearchHistoryRepository repo;

    public void saveOrUpdate(SearchHistory searchHistory){
        repo.save(searchHistory);
    }
    
}