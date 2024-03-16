package com.june_we_118.gallefaceshoppingmall.Service.ShopAndItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.june_we_118.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;
import com.june_we_118.gallefaceshoppingmall.Repo.ShopAndItemRepo.ItemRepository;

@Service
@EnableMongoRepositories(basePackages = "com.june_we_118.gallefaceshoppingmall.Repo.ShopAndItemRepo")
public class ItemService {

    @Autowired
    ItemRepository repo;

    public void saveOrUpdate(Item item){

        repo.save(item);
    }
    
}
