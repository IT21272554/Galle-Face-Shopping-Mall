package com.dev.gallefaceshoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.service.ItemService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<?> saveItem(@RequestBody Item item) {

        try {
            itemService.saveOrUpdate(item);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the item.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> allItems() {
        List<Item> items = itemService.allItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Item>> getPopularItems() {
        List<Item> items = itemService.getPopular();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
