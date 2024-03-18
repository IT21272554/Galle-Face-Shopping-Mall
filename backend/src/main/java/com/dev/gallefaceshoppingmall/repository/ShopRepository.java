package com.dev.Gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.Gallefaceshoppingmall.entity.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{

}
