package com.example.lampungmarket.models;

public class RegisterRequest {
    private String fullname;
    private String phone;
    private String email;
    private String password;

    public RegisterRequest(String fullname, String phone, String email, String password) {
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
