package com.dev.gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.entity.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{

}
