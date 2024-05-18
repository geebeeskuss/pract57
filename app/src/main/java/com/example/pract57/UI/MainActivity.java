package com.example.pract57.UI;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.pract57.R;
import com.example.pract57.ViewModel.NarutoViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NarutoViewModel catViewModel = new ViewModelProvider(this).get(NarutoViewModel.class);
    }
}