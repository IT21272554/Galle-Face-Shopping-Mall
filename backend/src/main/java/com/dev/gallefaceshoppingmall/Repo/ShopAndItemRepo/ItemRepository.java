package com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{
    
}
