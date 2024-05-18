package com.example.pract57.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pract57.Data.Repository.NarutoRepository;

import java.util.Random;

public class NarutoViewModel extends ViewModel {
    String[] femaleNames = {"Сакура", "Хината", "Ино", "Темари", "Куренай", "Цунаде"};
    String[] femaleTypes = {"хокаге", "анбу", "генин", "джоунин", "медик", "отступник", "чуунин"};

    private final MutableLiveData<NarutoRepository> uiState =
            new MutableLiveData(new NarutoRepository(null, null, null));
    public LiveData<NarutoRepository> getUIState() {
        return uiState;
    }

    public void inputNarutoParameters(String NarutoName, String NarutoType, String NarutoAge){
        uiState.setValue(
                new NarutoRepository(NarutoName, NarutoType, NarutoAge)
        );
    }

    public void RandomCat() {
        Random random = new Random();
        uiState.setValue(
                new NarutoRepository(
                        femaleTypes[random.nextInt(8)],
                        femaleNames[random.nextInt(6)],
                        String.valueOf(random.nextInt(20))
                )
        );
    }
}
