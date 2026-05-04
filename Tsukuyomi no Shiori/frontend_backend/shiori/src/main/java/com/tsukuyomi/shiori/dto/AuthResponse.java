package com.tsukuyomi.shiori.dto;

public class AuthResponse {

    private String token;
    private String tokenType;
    private Long userId;
    private String displayName;
    private String email;

    public AuthResponse() {
    }

    public AuthResponse(String token, String tokenType, Long userId, String displayName, String email) {
        this.token = token;
        this.tokenType = tokenType;
        this.userId = userId;
        this.displayName = displayName;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}