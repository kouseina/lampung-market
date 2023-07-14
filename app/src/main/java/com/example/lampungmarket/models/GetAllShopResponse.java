package com.example.lampungmarket.models;

public class GetAllShopResponse {
    private String success;
    private ShopItem[] data;

    public String getSuccess() {
        return success;
    }

    public ShopItem[] getData() {
        return data;
    }

    public GetAllShopResponse(String success, ShopItem[] data) {
        this.success = success;
        this.data = data;
    }
}
