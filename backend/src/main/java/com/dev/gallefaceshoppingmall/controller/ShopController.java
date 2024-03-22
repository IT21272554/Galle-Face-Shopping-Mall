package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.gallefaceshoppingmall.entity.Shop;
import com.dev.gallefaceshoppingmall.service.ShopService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/save")
    private String saveShop(@RequestBody Shop shop)
    {

        shopService.saveOrUpdate(shop);
        return shop.get_id();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Shop>getShops()
    {
        return shopService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Shop update(@RequestBody Shop shop1,@PathVariable(name = "id")String _id)
    {
        shop1.set_id(_id);
        shopService.saveOrUpdate(shop1);
        return shop1;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteShop(@PathVariable("id")String _id)
    {
       shopService.deleteShop(_id);
    }

    @RequestMapping("/search/{id}")
    private Shop getShopById(@PathVariable("id")String _id)
    {
        return shopService.getShopById(_id);
    }

}