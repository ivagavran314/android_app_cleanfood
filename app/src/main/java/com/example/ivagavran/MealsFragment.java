package com.example.ivagavran;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MealsFragment extends Fragment {
    ScreenSlidePagerAdapter2 screenSlidePagerAdapter2;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        screenSlidePagerAdapter2 = new ScreenSlidePagerAdapter2(getChildFragmentManager());
        viewPager = view.findViewById(R.id.pager2);
        viewPager.setAdapter(screenSlidePagerAdapter2);
    }
}