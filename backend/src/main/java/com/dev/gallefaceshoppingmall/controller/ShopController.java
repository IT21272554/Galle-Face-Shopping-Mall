package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.entity.Shop;
import com.dev.gallefaceshoppingmall.service.ShopService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/save")
    public ResponseEntity<?> saveShop(@RequestBody Shop shop){

        shopService.saveOrUpdate(shop);

        return ResponseEntity.ok().build();
    }
    
}
