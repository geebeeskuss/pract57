package com.example.pract57.UI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pract57.ViewModel.NarutoViewModel;
import com.example.pract57.R;

public class Fragment1 extends Fragment {
    public Fragment1() {
        super(R.layout.fragment_1);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText femaleType = (EditText) getActivity().findViewById(R.id.e_femaleType);
        EditText femaleName = (EditText) getActivity().findViewById(R.id.e_femaleName);
        EditText femaleAge = (EditText) getActivity().findViewById(R.id.e_age);

        NarutoViewModel femaleViewModel = new ViewModelProvider(getActivity()).get(NarutoViewModel.class);
        femaleViewModel.getUIState().observe(getViewLifecycleOwner(), uiState -> {
            if (uiState.getNarutoName() != null && uiState.getNarutoType() != null && uiState.getNarutoAge() != null) {
                femaleType.setText(uiState.getNarutoType());
                femaleName.setText(uiState.getNarutoName());
                femaleAge.setText(uiState.getNarutoAge());
            }
        });

        Button button_create = requireView().findViewById(R.id.b_create);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String female_type = femaleType.getText().toString();
                String female_name = femaleName.getText().toString();
                String female_age = femaleAge.getText().toString();

                femaleViewModel.inputNarutoParameters(female_type, female_name, female_age);
                Navigation.findNavController(view).navigate(R.id.action_Fragment1_to_Fragment2);
            }
        });

        Button button_create_random = requireView().findViewById(R.id.b_createRandom);
        button_create_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                femaleViewModel.RandomCat();
                Navigation.findNavController(view).navigate(R.id.action_Fragment1_to_Fragment2);
            }
        });
    }
}