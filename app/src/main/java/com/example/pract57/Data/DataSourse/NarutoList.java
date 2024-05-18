package com.example.pract57.Data.DataSourse;

import com.example.pract57.Data.Model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NarutoList {
    private Map<Integer, Item> narutos;
    public NarutoList(Map<Integer, Item> narutos) {
        this.narutos = narutos;
    }
    public ArrayList<Item> getNaruto() {
        return new ArrayList<Item>(narutos.values());
    }

    public int addNarutoToList(Item item) {
        if (narutos != null) {
            Set<Integer> set = narutos.keySet();
            if (set.size() > 0) {
                int maxId = Collections.max(set);
                narutos.put(maxId + 1, item);
                return maxId + 1;
            } else {
                int index = 0;
                narutos.put(index, item);
                return index;
            }
        } else {
            narutos = new HashMap<Integer, Item>();
            int index = 0;
            narutos.put(index, item);
            return index;
        }
    }

    public Item getNarutoById(int id) {return narutos != null ? narutos.get(id) : null;}

    public boolean updateNarutoById(int id, Item animal) {
        if (narutos == null || narutos.get(id) == null) return false;
        narutos.put(id, animal);
        return true;
    }

    public boolean deleteNarutoById(int id) {
        if (narutos == null || narutos.get(id) == null) return false;
        narutos.remove(id);
        return true;
    }
}