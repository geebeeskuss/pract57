package com.example.pract57.Data.Model;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private int imageResId;

    public Item(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }
    public String getName() {
        return name;
    }
    public int getImageResId() {
        return imageResId;
    }
}