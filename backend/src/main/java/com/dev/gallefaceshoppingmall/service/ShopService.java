package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Shop;
import com.dev.gallefaceshoppingmall.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public void saveOrUpdate(Shop shops){

        shopRepository.save(shops);
    }

    public Iterable<Shop> listAll() {
       
        return this.shopRepository.findAll();
    }

    public void deleteShop(String _id) {
        
        shopRepository.deleteById(_id);
    }

    public Shop getShopById(String _id) {
        
        return shopRepository.findById(_id).get();
    }

}