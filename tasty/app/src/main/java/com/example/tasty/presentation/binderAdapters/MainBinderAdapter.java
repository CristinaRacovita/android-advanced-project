package com.example.tasty.presentation.binderAdapters;

import android.util.Log;
import android.widget.FrameLayout;

import androidx.databinding.BindingAdapter;

public class MainBinderAdapter {

    @BindingAdapter({"string"})
    public static void getItem(FrameLayout frameLayout, String string) {
        Log.d("MAIN ACTIVITY", "main activity" + string);
    }
}
