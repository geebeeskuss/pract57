package com.example.pract57.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pract57.Data.Model.Item;
import com.example.pract57.Data.Repository.NarutoRepository;
import com.example.pract57.Data.Repository.NarutoListRepository;

import java.util.ArrayList;

public class NarutoListViewModel extends ViewModel {
    private final MutableLiveData<NarutoListRepository> uiState =
            new MutableLiveData(new NarutoListRepository(null));
    public LiveData<NarutoListRepository> getUIState() {
        return uiState;
    }

    public void addGoodToOrder(Item item) {
        NarutoListRepository narutoList;
        narutoList = uiState.getValue();
        if (narutoList != null)
            narutoList.putNaruto(item);
        else {
            ArrayList<Item> items = new ArrayList<>();
            items.add(item);
            narutoList = new NarutoListRepository(items);
        }

        uiState.setValue(narutoList);
    }
}

