package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.SearchHistory;
import com.dev.gallefaceshoppingmall.repository.SearchEngineRepository;

@Service
@EnableMongoRepositories(basePackages = "com.dev.gallefaceshoppingmall.Repo.SearchEngineRepo")
public class SearchEngineService {

    @Autowired
    SearchEngineRepository repo;

    public void saveOrUpdate(SearchHistory searchHistory){
        repo.save(searchHistory);
    }
    
}
