package com.dev.gallefaceshoppingmall.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.gallefaceshoppingmall.dto.SignUpRequest;
import com.dev.gallefaceshoppingmall.dto.SigninRequest;
import com.dev.gallefaceshoppingmall.entity.User;
import com.dev.gallefaceshoppingmall.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User>signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin());
    }

}
