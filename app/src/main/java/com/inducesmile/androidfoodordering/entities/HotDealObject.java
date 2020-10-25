package com.inducesmile.androidfoodordering.entities;


public class HotDealObject {

    private String item_name;
    private String description;
    private float item_price;
    private String item_picture;

    public HotDealObject(String item_name, String description, String item_picture, float item_price) {
        this.item_name = item_name;
        this.description = description;
        this.item_price = item_price;
        this.item_picture = item_picture;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getDescription() {
        return description;
    }

    public float getItem_price() {
        return item_price;
    }

    public String getItem_picture() {
        return item_picture;
    }
}
