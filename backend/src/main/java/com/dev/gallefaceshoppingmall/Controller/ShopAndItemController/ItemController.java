package com.dev.gallefaceshoppingmall.Controller.ShopAndItemController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;
import com.dev.gallefaceshoppingmall.Service.ShopAndItemService.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/item")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<?> saveItem(@RequestBody Item item) {
        
        itemService.saveOrUpdate(item);
        
        return ResponseEntity.ok().build();
    }
    
}
