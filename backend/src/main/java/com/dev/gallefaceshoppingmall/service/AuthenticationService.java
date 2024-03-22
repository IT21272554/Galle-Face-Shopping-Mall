package com.dev.gallefaceshoppingmall.service;

import com.dev.gallefaceshoppingmall.dto.SignUpRequest;
import com.dev.gallefaceshoppingmall.entity.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    Object signin();

}
