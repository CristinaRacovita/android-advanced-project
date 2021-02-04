package com.example.tasty.data;

import com.google.gson.annotations.SerializedName;

public class RecipeItemDTO {
<<<<<<< HEAD
    @SerializedName("title")
    private final String titleRecipe;
=======
    @SerializedName("recipe_id")
    private final String recipeTitleId;
>>>>>>> new_language

    @SerializedName("image_url")
    private final String imageUrl;

    public RecipeItemDTO(String titleRecipe, String imageUrl) {
        this.recipeTitleId = titleRecipe;
        this.imageUrl = imageUrl;
    }

    public String getRecipeTitleId() {
        return recipeTitleId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
