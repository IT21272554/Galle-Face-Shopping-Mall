package com.dev.gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.gallefaceshoppingmall.entity.SearchHistory;


public interface SearchEngineRepository extends MongoRepository<SearchHistory, String> {
    
}
