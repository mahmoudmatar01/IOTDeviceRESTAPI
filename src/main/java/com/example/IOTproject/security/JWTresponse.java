package com.example.IOTproject.security;

public class JWTresponse {
    private String token;
    public JWTresponse(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
