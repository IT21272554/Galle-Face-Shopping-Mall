package com.dev.gallefaceshoppingmall.Service.ShopAndItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;
import com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo.ItemRepository;

@Service
@EnableMongoRepositories(basePackages = "com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo")
public class ItemService {

    @Autowired
    ItemRepository repo;

    public void saveOrUpdate(Item item){

        repo.save(item);
    }
    
}
