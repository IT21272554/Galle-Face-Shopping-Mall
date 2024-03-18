package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.entity.SearchHistory;
import com.dev.gallefaceshoppingmall.service.SearchEngineService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/search")
public class SearchEngineController {

    @Autowired(required = true)
    private SearchEngineService searchEngineService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSearchHistory(@RequestBody SearchHistory searchHistory) {
        searchEngineService.saveOrUpdate(searchHistory);
        return ResponseEntity.ok().build();
    }

}
