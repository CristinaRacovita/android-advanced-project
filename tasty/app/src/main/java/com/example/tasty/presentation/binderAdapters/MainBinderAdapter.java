package com.example.tasty.presentation.binderAdapters;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBinderAdapter {

    @BindingAdapter({"fragment"})
    public static void getItem(BottomNavigationView bottomNavigationView, @IdRes int fragment) {
        NavHostFragment navHostFragment = (NavHostFragment) ((AppCompatActivity) bottomNavigationView.getContext()).getSupportFragmentManager().findFragmentById(fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }
}
