package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.gallefaceshoppingmall.service.SearchHistoryService;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/history")
public class SearchHistoryController {

    @Autowired(required = true)
    private SearchHistoryService searchHistoryService;
   

    @GetMapping(value = "/save/{id}")
    public ResponseEntity<?> updateViewCount(@PathVariable String id) {
        searchHistoryService.saveOrUpdate( id);
        return ResponseEntity.ok().build();
    }

}
