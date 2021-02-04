package com.example.tasty.presentation.binderAdapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.tasty.domain.model.RecipeItem;

import timber.log.Timber;


public class RecipeItemBinderAdapter {
    private static final String TAG = "Item Binder Adapter";

    @BindingAdapter({"image_url"})
    public static void loadImage(TextView textView, String imageUrl) {
        Glide.with(textView.getContext())
                .load(imageUrl)
                .into(new CustomTarget<Drawable>() {

                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        Timber.d("Image is loaded");
                        textView.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    @BindingAdapter({"recipe"})
    public static void setFavouriteRecipe(ToggleButton toggleButton, RecipeItem recipe) {
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            recipe.setFavourite(isChecked);
            Timber.d(recipe.getFavourite().toString());
        });
    }

    @BindingAdapter({"titleRes"})
    public static void setTitle(TextView textView, String titleRes) {
        Context context = textView.getContext();
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(titleRes, "string", packageName);
        String title = context.getString(resId);
        textView.setText(title);
    }
}
