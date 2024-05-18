package com.example.pract57.Data.DataSourse;

import com.example.pract57.Data.Model.Item;

public class CurrentNaruto {
    private final Item[] currentItem = new Item[1];
    public CurrentNaruto (Item naruto) {this.currentItem[0] = naruto;}
    public Item getCurrentNaruto() {
        return currentItem[0];
    }
    public void SetCurrentNaruto(Item naruto) {
        this.currentItem[0] = naruto;
    }
}

