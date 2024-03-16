package com.june_we_118.gallefaceshoppingmall.Service.SearchEngineService;

import com.june_we_118.gallefaceshoppingmall.Entity.SearchEngineEntity.SearchHistory;
import com.june_we_118.gallefaceshoppingmall.Repo.SearchEngineRepo.SearchEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableMongoRepositories(basePackages = "com.june_we_118.gallefaceshoppingmall.Repo")
public class SearchEngineService {

    @Autowired
    SearchEngineRepository repo;

    public void saveOrUpdate(SearchHistory searchHistory){
        repo.save(searchHistory);
    }
    
}
