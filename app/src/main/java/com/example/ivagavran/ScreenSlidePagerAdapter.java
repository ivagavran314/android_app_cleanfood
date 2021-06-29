package com.example.ivagavran;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4;
    private static final String BASE_NAME = "Advice #%d";

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ScreenSlidePageFragment.newInstance("Veggies first","Vegetables are important sources of many nutrients, including potassium, dietary fiber and vitamin C. They provide nutrients vital for health and maintenance of your body.");
            case 1:
                return ScreenSlidePageFragment.newInstance("Drink water", "Drinking water, whether from the tap or a bottle, is the best source of fluid for the body." );
            case 2:
                return ScreenSlidePageFragment.newInstance("Take Mg", "Magnesium regulates glucose and insulin levels, as well as the neurotransmitter dopamine. A deficiency will cause intense sugar cravings, especially for chocolate.");
            default:
                return ScreenSlidePageFragment.newInstance("Soy milk", "Vegetable milk is rich in protein and vitamins and these elements make it an excellent substitute for cow's milk");
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return String.format(Locale.getDefault(), BASE_NAME, position + 1);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
