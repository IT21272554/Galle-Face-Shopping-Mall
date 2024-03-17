package com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{

}
