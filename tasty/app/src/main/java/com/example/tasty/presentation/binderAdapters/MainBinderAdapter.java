package com.example.tasty.presentation.binderAdapters;

import android.util.Log;
import android.widget.FrameLayout;

import androidx.databinding.BindingAdapter;

public class MainBinderAdapter {

    @BindingAdapter("get")
    public static void getItem(FrameLayout frameLayout) {
        Log.d("MAIN ACTIVITY", "main activity binder adapter works");
    }
}
