package com.june_we_118.gallefaceshoppingmall.Repo.ShopAndItemRepo;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.june_we_118.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;


public interface ItemRepository extends MongoRepository<Item, String>{
    
}
