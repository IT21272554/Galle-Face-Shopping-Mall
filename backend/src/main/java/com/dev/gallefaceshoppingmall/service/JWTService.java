package com.dev.gallefaceshoppingmall.service;

import org.springframework.security.core.userdetails.UserDetails;


public interface JWTService {

    static String extractUserName(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserName'");
    }

    static String generateToken(UserDetails userDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateToken'");
    }

    static boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername())&& !isTokenValid(token, userDetails));
    }

    static String extractUsername(String jwt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUsername'");
    }
}
