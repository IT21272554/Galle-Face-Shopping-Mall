package com.dev.gallefaceshoppingmall.Repo.SearchEngineRepo;

import com.dev.gallefaceshoppingmall.Entity.SearchEngineEntity.SearchHistory;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SearchEngineRepository extends MongoRepository<SearchHistory, String> {
    
}
