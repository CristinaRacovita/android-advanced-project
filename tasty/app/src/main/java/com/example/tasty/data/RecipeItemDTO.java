package com.example.tasty.data;

import com.google.gson.annotations.SerializedName;

public class RecipeItemDTO {
    @SerializedName("recipe_id")
    private final String recipeTitleId;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("favourite")
    private final Boolean isFav;

    public RecipeItemDTO(String titleRecipe, String imageUrl, Boolean isFav) {
        this.recipeTitleId = titleRecipe;
        this.imageUrl = imageUrl;
        this.isFav = isFav;
    }

    public String getRecipeTitleId() {
        return recipeTitleId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Boolean getFav() {
        return isFav;
    }
}
