package com.example.lampungmarket.models;

import java.io.Serializable;

public class ShopItem implements Serializable {
    public final String id;
    public final String name;
    public final String description;
    public final String price;
    public final String image_url;
    public final String maps_url;
    public final String address;
    public final String open_hours;

    public ShopItem(String id, String name, String description, String price, String image_url, String maps_url, String address, String open_hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.maps_url = maps_url;
        this.address = address;
        this.open_hours = open_hours;
    }
}
