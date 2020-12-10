package com.example.tasty.data;

import com.google.gson.annotations.SerializedName;

public class RecipeItemDTO {
    private String titleRecipe;

    @SerializedName("image_url")
    private String imageUrl;

    public RecipeItemDTO(String titleRecipe, String imageUrl) {
        this.titleRecipe = titleRecipe;
        this.imageUrl = imageUrl;
    }

    public String getTitleRecipe() {
        return titleRecipe;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
