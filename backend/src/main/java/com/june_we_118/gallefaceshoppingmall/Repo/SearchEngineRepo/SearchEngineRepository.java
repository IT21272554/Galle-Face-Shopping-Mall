package com.june_we_118.gallefaceshoppingmall.Repo.SearchEngineRepo;

import com.june_we_118.gallefaceshoppingmall.Entity.SearchEngineEntity.SearchHistory;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SearchEngineRepository extends MongoRepository<SearchHistory, String> {
    
}
