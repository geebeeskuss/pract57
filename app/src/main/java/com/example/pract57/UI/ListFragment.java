package com.example.pract57.UI;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pract57.Data.Model.Item;
import com.example.pract57.R;
import com.example.pract57.ViewModel.NarutoViewModel;
import com.example.pract57.ViewModel.NarutoListViewModel;

import java.util.List;

public class ListFragment extends Fragment {
    public static class YourCustomRecyclerViewAdapter extends RecyclerView.Adapter<YourCustomRecyclerViewAdapter.ViewHolder> {
        private List<Item> dataList;
        private OnItemClicked onClick;
        public interface OnItemClicked {
            void onItemClick(int position);
        }
        public YourCustomRecyclerViewAdapter(List<Item> dataList) {
            this.dataList = dataList;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Item item = dataList.get(position);
            holder.textView.setText(item.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onItemClick(holder.getAdapterPosition());
                }
            });
        }
        @Override
        public int getItemCount() {
            return dataList.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
        public void setOnClick(OnItemClicked onClick){
            this.onClick=onClick;
        }
    }
    public ListFragment() {
        super(R.layout.fragment_list);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        Button addNewFemale_button = (Button) getActivity().findViewById(R.id.b_addNewCat);
        RecyclerView itemsList = getActivity().findViewById(R.id.recycler_view);
        NarutoListViewModel narutoViewModel = new ViewModelProvider(getActivity()).get(NarutoListViewModel.class);

        narutoViewModel.getUIState().observe(getViewLifecycleOwner(), uiState -> {
            List<Item> items = uiState.getNarutoPositions();

            if (items == null || items.size() == 0) {
                itemsList.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "There is no Naruto's character", Toast.LENGTH_SHORT).show();
            } else {
                if (itemsList.getVisibility() == View.GONE)
                    itemsList.setVisibility(View.VISIBLE);

                YourCustomRecyclerViewAdapter adapter = new YourCustomRecyclerViewAdapter(items);
                LinearLayoutManager layoutManager = new
                        LinearLayoutManager(this.getContext().getApplicationContext());
                itemsList.setLayoutManager(layoutManager);

                adapter.setOnClick(new YourCustomRecyclerViewAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {
                        if (narutoViewModel.getUIState().getValue() != null) {
                            Item item = (Item) narutoViewModel.getUIState().getValue().getNaruto(position);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("Item", item);
                            navController.navigate(R.id.action_FragmentList_to_Fragment1, bundle);
                        }
                    }
                });
                itemsList.setAdapter(adapter);
            }
        });

        addNewFemale_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_FragmentList_to_Fragment1);
            }
        });
    }
}