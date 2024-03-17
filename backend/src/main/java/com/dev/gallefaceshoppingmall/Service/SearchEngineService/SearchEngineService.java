package com.dev.gallefaceshoppingmall.Service.SearchEngineService;

import com.dev.gallefaceshoppingmall.Entity.SearchEngineEntity.SearchHistory;
import com.dev.gallefaceshoppingmall.Repo.SearchEngineRepo.SearchEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableMongoRepositories(basePackages = "com.dev.gallefaceshoppingmall.Repo.SearchEngineRepo")
public class SearchEngineService {

    @Autowired
    SearchEngineRepository repo;

    public void saveOrUpdate(SearchHistory searchHistory){
        repo.save(searchHistory);
    }
    
}
