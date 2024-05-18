package com.example.pract57.Data.Repository;

import com.example.pract57.Data.DataSourse.CurrentNaruto;
import com.example.pract57.Data.Model.Item;

public class NarutoRepository {
    private CurrentNaruto currentNaruto;
    private String NarutoName = "test";
    private String NarutoType = "test";
    private String NarutoAge = "0";

    public NarutoRepository() {
    }

    public NarutoRepository(String NarutoName) {
        this.NarutoName = NarutoName;
        currentNaruto = new CurrentNaruto(new Item(NarutoName, 0));
    }

    public NarutoRepository(String NarutoType, String NarutoName) {
        this.NarutoType = NarutoType;
        this.NarutoName = NarutoName;
        currentNaruto = new CurrentNaruto(new Item(NarutoName, 0));
    }

    public NarutoRepository(String NarutoType, String NarutoName, String NarutoAge) {
        this.NarutoType = NarutoType;
        this.NarutoName = NarutoName;
        this.NarutoAge = NarutoAge;
        currentNaruto = new CurrentNaruto(new Item(NarutoType + " " + NarutoName +
                " " + NarutoAge + " лет", 0));
    }

    public void setNarutoName(String NarutoName) {
        this.NarutoName = NarutoName;
        currentNaruto.SetCurrentNaruto(new Item(NarutoName, 0));
    }

    public void setNarutoType(String NarutoType) {
        this.NarutoType = NarutoType;
    }

    public void setNarutoAge(String NarutoAge) {
        this.NarutoAge = NarutoAge;
    }

    public String getNarutoName() {
        return NarutoName;
    }

    public String getNarutoType() {
        return NarutoType;
    }

    public String getNarutoAge() {
        return NarutoAge;
    }

    public Item getNaruto() {
        return currentNaruto.getCurrentNaruto();
    }
}
