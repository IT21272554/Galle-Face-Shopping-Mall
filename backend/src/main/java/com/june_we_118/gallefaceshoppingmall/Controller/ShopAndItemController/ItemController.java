package com.june_we_118.gallefaceshoppingmall.Controller.ShopAndItemController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.june_we_118.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;
import com.june_we_118.gallefaceshoppingmall.Service.ShopAndItemService.ItemService;
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
