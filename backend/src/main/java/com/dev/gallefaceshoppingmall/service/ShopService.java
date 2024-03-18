package com.dev.Gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.Gallefaceshoppingmall.entity.Shop;
import com.dev.Gallefaceshoppingmall.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired(required = true)
    ShopRepository shopRepository;

    public void saveOrUpdate(Shop shop){

        shopRepository.save(shop);
    }
}
