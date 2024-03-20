package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dev.gallefaceshoppingmall.entity.LoginCredentials;
import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.service.UserService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody LoginCredentials credentials) {
        try {
            User user = userService.loginUser(credentials.getEmail(), credentials.getPassword());
            if (user != null) {
                // Login successful, you can return a token or any user information here
                return ResponseEntity.ok(user); // Modify this based on your authentication flow
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid email or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while logging in the user.");
        }
    }
}
