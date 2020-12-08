package com.example.tasty.domain.model;

import androidx.annotation.DrawableRes;

public class RecipeItem {
    private String titleRecipe;
    @DrawableRes
    private int imageDrawableResource;

    public RecipeItem(String titleRecipe, int imageDrawableResource) {
        this.titleRecipe = titleRecipe;
        this.imageDrawableResource = imageDrawableResource;
    }

    public String getTitleRecipe() {
        return titleRecipe;
    }

    public void setTitleRecipe(String titleRecipe) {
        this.titleRecipe = titleRecipe;
    }

    public int getImageDrawableResource() {
        return imageDrawableResource;
    }

    public void setImageDrawableResource(int imageDrawableResource) {
        this.imageDrawableResource = imageDrawableResource;
    }
}
