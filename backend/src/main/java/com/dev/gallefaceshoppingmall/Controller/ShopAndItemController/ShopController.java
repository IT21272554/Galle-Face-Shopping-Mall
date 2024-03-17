package com.dev.gallefaceshoppingmall.Controller.ShopAndItemController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Shop;
import com.dev.gallefaceshoppingmall.Service.ShopAndItemService.ShopService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping
    public ResponseEntity<?> saveShop(@RequestBody Shop shop){

        shopService.saveOrUpdate(shop);

        return ResponseEntity.ok().build();
    }
    
}
