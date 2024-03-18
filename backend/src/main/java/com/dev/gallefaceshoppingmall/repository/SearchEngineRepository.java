package com.dev.Gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.Gallefaceshoppingmall.entity.SearchHistory;


public interface SearchEngineRepository extends MongoRepository<SearchHistory, String> {
    
}
