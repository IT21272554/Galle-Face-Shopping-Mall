package com.dev.gallefaceshoppingmall.service;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserDetailsService userDetailsService();

}
