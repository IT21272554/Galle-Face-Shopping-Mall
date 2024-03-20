package com.dev.gallefaceshoppingmall.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.entity.SearchHistory;

@Repository
public interface SearchHistoryRepository extends MongoRepository<SearchHistory, String> {
    
    
}
