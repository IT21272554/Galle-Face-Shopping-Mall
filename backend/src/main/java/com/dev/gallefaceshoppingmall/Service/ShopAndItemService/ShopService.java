package com.dev.gallefaceshoppingmall.Service.ShopAndItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Shop;
import com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo.ShopRepository;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public void saveOrUpdate(Shop shop){

        shopRepository.save(shop);
    }
}
