package com.dev.gallefaceshoppingmall.controller;

public class JwtAuthenticationResponse {

    private String accessToken;
    private String tokenType = "Bearer ";
    private String token;
    private JwtAuthenticationResponse refreshToken;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(Object jwt) {
        this.token = (String) jwt;
    }

    public JwtAuthenticationResponse getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(JwtAuthenticationResponse jwtAuthenticationResponse) {
        this.refreshToken = jwtAuthenticationResponse;
    }
}
