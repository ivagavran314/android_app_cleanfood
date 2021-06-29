package com.example.ivagavran;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StartFragment extends Fragment {

    public StartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        Button bMeals = view.findViewById(R.id.bMeals);
        Button bJournal = view.findViewById(R.id.bJournal);
        Button bBlog = view.findViewById(R.id.bAdvices);
        bMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_startFragment_to_mealsFragment);
            }
        });
        bJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_startFragment_to_journalFragment);
            }
        });
        bBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_startFragment_to_blogFragment);
            }
        });
    }
}