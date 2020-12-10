package com.example.tasty.domain.model;

public class RecipeItem {
    private String titleRecipe;
    private String imageUrl;

    public RecipeItem(String titleRecipe, String imageUrl) {
        this.titleRecipe = titleRecipe;
        this.imageUrl = imageUrl;
    }

    public String getTitleRecipe() {
        return titleRecipe;
    }

    public void setTitleRecipe(String titleRecipe) {
        this.titleRecipe = titleRecipe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
