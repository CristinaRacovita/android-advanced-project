package com.example.tasty.presentation.binderAdapters;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;


public class RecipeItemBinderAdapter {
    private static final String TAG = "Item Binder Adapter";

    @BindingAdapter({"image_url"})
    public static void loadImage(TextView textView, String imageUrl) {
        Glide.with(textView.getContext())
                .load(imageUrl)
                .into(new CustomTarget<Drawable>() {

                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        Log.d(TAG, "Image is loaded");
                        textView.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }
}
