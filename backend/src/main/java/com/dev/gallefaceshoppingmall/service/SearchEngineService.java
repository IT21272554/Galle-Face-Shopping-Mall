package com.dev.Gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.Gallefaceshoppingmall.entity.SearchHistory;
import com.dev.Gallefaceshoppingmall.repository.SearchEngineRepository;

@Service
public class SearchEngineService {

    @Autowired
    SearchEngineRepository repo;

    public void saveOrUpdate(SearchHistory searchHistory){
        repo.save(searchHistory);
    }
    
}
