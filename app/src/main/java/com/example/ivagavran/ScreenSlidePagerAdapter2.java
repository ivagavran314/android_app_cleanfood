package com.example.ivagavran;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapter2 extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4;
    private static final String BASE_NAME = "Meal #%d";

    public ScreenSlidePagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ScreenSlidePageFragment2.newInstance("Turkey apple patties with kale", "These protein-packed turkey apple patties will keep you satisfied for hours. Paired with a fresh side salad topped with nutrient-packed seeds, you will have an egg-free, whole-food breakfast, lunch, or dinner that you can feel good about.");
            case 1:
                return ScreenSlidePageFragment2.newInstance("Smoked salmon with avocado and watercress", "This is an ideal healthy keto breakfast. Few carbs, healthy fats, and lots of potassium and fiber. Moreover, smoked salmon contains quite a bit of salt, which can be beneficial on a low-carb or ketogenic diet. Make sure to drink plenty of fluids! This keto recipe is from a collaboration with the celebrated low-carb chef Pascale Naessens.");
            case 2:
                return ScreenSlidePageFragment2.newInstance("Low-carb chia pudding", "This sweet, low carb chia pudding is wonderful for breakfast - or a snack or dessert. Prepare the night before; that way, in the morning, you are all set. The proof is in the pudding!");
            default:
                return ScreenSlidePageFragment2.newInstance("BLTA lettuce wraps", "Vine-ripened tomato, crispy bacon, creamy avocado, and tangy mayo come together to create the perfect keto spin on a classic sandwich! Sorry, bread, you aren’t invited to the party!");
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
