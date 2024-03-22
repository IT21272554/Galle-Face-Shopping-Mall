package com.dev.gallefaceshoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.service.SearchEngineService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/search")
public class SearchEngineController {

    @Autowired
    SearchEngineService searchEngineService;

    @GetMapping("/items/{text}")
    public ResponseEntity<List<Item>> searchItemsOnly(@PathVariable String text){
        List<Item> items = searchEngineService.searchItems(text);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
