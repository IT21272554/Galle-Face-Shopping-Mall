package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.entity.SearchHistory;
import com.dev.gallefaceshoppingmall.service.SearchHistoryService;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/history")
public class SearchHistoryController {

    @Autowired(required = true)
    private SearchHistoryService searchHistoryService;
   

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSearchHistory(@RequestBody SearchHistory searchHistory) {
        searchHistoryService.saveOrUpdate(searchHistory);
        return ResponseEntity.ok().build();
    }

}
