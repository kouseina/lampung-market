package com.example.lampungmarket.models;

public class LoginResponse {
    public Boolean success;
    public UserItem data;

    public LoginResponse(Boolean success, UserItem data) {
        this.success = success;
        this.data = data;
    }
}
