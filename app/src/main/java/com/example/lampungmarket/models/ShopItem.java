package com.example.lampungmarket.models;

public class ShopItem {
    public final Integer id;
    public final String name;
    public final String description;
    public final Integer price;
    public final String image_url;
    public final String maps_url;

    public ShopItem(Integer id, String name, String description, Integer price, String image_url, String maps_url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.maps_url = maps_url;
    }
}
