package com.example.pract57.Data.Repository;

import com.example.pract57.Data.DataSourse.NarutoList;
import com.example.pract57.Data.Model.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class NarutoListRepository {
    NarutoList narutoList = null;
    public NarutoListRepository(ArrayList<Item> values) {
        if (values != null) {
            this.narutoList = new NarutoList(new HashMap<Integer, Item>());
            for (Item good : values) {
                narutoList.addNarutoToList(good);
            }
        }
    }
    public ArrayList<Item> getNarutoPositions() {
        if (narutoList != null) return narutoList.getNaruto();
        return null;
    }
    public void setNarutoPositions(ArrayList<Item> orderedPositions) {
        if (narutoList == null)
            narutoList = new NarutoList(new HashMap<Integer, Item>());
        for (Item naruto : orderedPositions) {
            narutoList.addNarutoToList(naruto);
        }
    }
    public void putNaruto(Item animal) {
        if (narutoList != null)
            narutoList.addNarutoToList(animal);
        else {
            narutoList = new NarutoList(new HashMap<Integer, Item>());
            narutoList.addNarutoToList(animal);
        }
    }
    public Item getNaruto(int position) {
        if (narutoList != null)
            return narutoList.getNarutoById(position);
        return null;
    }
}
