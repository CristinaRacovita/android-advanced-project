package com.example.tasty.presentation.binderAdapters;

import android.util.Log;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.databinding.BindingAdapter;

public class MainBinderAdapter {

    @BindingAdapter({"bottomNav"})
    public static void getItem(FrameLayout frameLayout, BottomNavigationView bottomNavigationView) {
        Log.d("MAIN ACTIVITY", "main activity binder adapter works");
    }
}
