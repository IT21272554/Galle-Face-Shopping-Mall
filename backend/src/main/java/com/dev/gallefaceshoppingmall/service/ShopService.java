package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Shop;
import com.dev.gallefaceshoppingmall.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired(required = true)
    ShopRepository shopRepository;

    public void saveOrUpdate(Shop shop){

        shopRepository.save(shop);
    }
}
