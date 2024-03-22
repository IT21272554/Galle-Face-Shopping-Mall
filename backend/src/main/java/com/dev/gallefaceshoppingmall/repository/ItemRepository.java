package com.dev.gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.entity.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{


    
}
