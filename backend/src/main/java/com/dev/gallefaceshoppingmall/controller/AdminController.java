package com.dev.gallefaceshoppingmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {


    @GetMapping
    public ResponseEntity<String> sayHellow(){
        return ResponseEntity.ok("Hi again");
    }
}
