package com.example.pract57.UI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pract57.Data.Model.Item;
import com.example.pract57.R;
import com.example.pract57.ViewModel.NarutoViewModel;
import com.example.pract57.ViewModel.NarutoListViewModel;

import java.util.Objects;

public class Fragment2 extends Fragment {
    public Fragment2() {
        super(R.layout.fragment_2);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView femaleType = (TextView) getActivity().findViewById(R.id.t_type);
        TextView femaleName = (TextView) getActivity().findViewById(R.id.t_name);
        TextView femaleAge = (TextView) getActivity().findViewById(R.id.t_age);
        Button button_recreate_random = requireView().findViewById(R.id.b_recreateRandom);
        Button button_return = requireView().findViewById(R.id.b_return);
        Button button_addToList = requireView().findViewById(R.id.b_addToList);

        NarutoViewModel femaleViewModel = new ViewModelProvider(getActivity()).get(NarutoViewModel.class);
        if (getArguments() == null) {
            femaleViewModel.getUIState().observe(getViewLifecycleOwner(), uiState -> {
                femaleType.setText("Ранг: " + uiState.getNarutoType());
                femaleName.setText("Имя: " + uiState.getNarutoName());
                femaleAge.setText("Возраст: " + uiState.getNarutoAge());
            });
        } else {
            Item cat = (Item) getArguments().getSerializable("Item");
            String[] parts = cat.getName().split(" ");
            femaleType.setText("Ранг: " + parts[0]);
            femaleName.setText("Имя: " + parts[1]);
            femaleAge.setText("Возраст: " + parts[2]);
            button_addToList.setVisibility(View.GONE);
            button_recreate_random.setVisibility(View.GONE);
        }
        button_recreate_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                femaleViewModel.RandomCat();
            }
        });

        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getArguments() == null)
                    Navigation.findNavController(view).navigate(R.id.action_Fragment2_to_Fragment1);
                else {
                    Navigation.findNavController(view).navigate(R.id.action_Fragment2_to_FragmentList);
                }
            }
        });

        NarutoListViewModel narutoListViewModel = new ViewModelProvider(getActivity()).get(NarutoListViewModel.class);
        button_addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                narutoListViewModel.addGoodToOrder(femaleViewModel.getUIState().getValue().getNaruto());
                femaleViewModel.inputNarutoParameters(null, null, null);

                Navigation.findNavController(view).navigate(R.id.action_Fragment2_to_FragmentList);
            }
        });
    }
}