package com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;


public interface ItemRepository extends MongoRepository<Item, String>{
    
}
