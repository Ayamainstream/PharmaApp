package com.example.pharmacy.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacy.Adapters.DrugRecyclerViewAdapter;
import com.example.pharmacy.R;
import com.example.pharmacy.RoomDatabase.FoodRoom;
import com.example.pharmacy.RoomDatabase.FoodViewModel;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Fragment where the items appear to user to choose one of them
 */
public class HomeFragment extends Fragment {
    FoodViewModel drugViewModel;
    private TextView amountTextView;

    Animation fadeInAnimation;
    Animation fadeOutAndroidAnimation;

    public HomeFragment() {
        // Required empty public constructor
    }

    DrugRecyclerViewAdapter adapter;
    int lastPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        adapter = new DrugRecyclerViewAdapter(getActivity());
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        drugViewModel = ViewModelProviders.of(HomeFragment.this).get(FoodViewModel.class);
        drugViewModel.getAllFood().observe(HomeFragment.this, new Observer<List<FoodRoom>>() {
            @Override
            public void onChanged(@Nullable List<FoodRoom> foods) {
                adapter.setNewList(foods);

                double totalAmount = 0;
                for (int i = 0; i < foods.size(); i++) {
                    if(foods.get(i).getCount() != 0) {
                        totalAmount += foods.get(i).getPrice();
                    }
                }
                setAmount(totalAmount);
            }
        });

        adapter.setOnItemClickListener(new DrugRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FoodRoom food, int position) {
                if (food.getCount() == 0) {
                    food.setCount(1);
                    drugViewModel.update(food);
                } else {
                    food.setCount(0);
                    drugViewModel.update(food);
                }
                lastPosition = position;
            }
        });

        amountTextView = v.findViewById(R.id.text_view_amount);
        amountTextView.setVisibility(View.GONE);
        fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in_animation);
        fadeOutAndroidAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out_animation);


        return v;
    }

    /**
     * Set the total amount on bottom of fragment
     *
     * @param totalAmount the total amount of selected items
     */
    private void setAmount(double totalAmount) {
        DecimalFormat df = new DecimalFormat("####");
        if(totalAmount == 0){
            if(amountTextView.getVisibility() == View.VISIBLE)
                amountTextView.startAnimation(fadeOutAndroidAnimation);
            amountTextView.setVisibility(View.GONE);
        }else {
            if(amountTextView.getVisibility() == View.GONE)
                amountTextView.startAnimation(fadeInAnimation);
            amountTextView.setVisibility(View.VISIBLE);
            amountTextView.setText("Общая сумма: " + df.format(totalAmount));
        }
    }

}
