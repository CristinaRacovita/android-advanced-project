package com.example.tasty.data;

import androidx.annotation.DrawableRes;

public class RecipeItemDTO {
    private String titleRecipe;
    @DrawableRes
    private int imageDrawableResource;

    public RecipeItemDTO(String titleRecipe, int imageDrawableResource) {
        this.titleRecipe = titleRecipe;
        this.imageDrawableResource = imageDrawableResource;
    }

    public String getTitleRecipe() {
        return titleRecipe;
    }

    public int getImageDrawableResource() {
        return imageDrawableResource;
    }
}
