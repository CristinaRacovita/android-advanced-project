package com.example.tasty.domain.model;

public class RecipeItem {
    private String titleRecipe;
    private String imageUrl;
    private Boolean isFavourite;

    public RecipeItem(String titleRecipe, String imageUrl) {
        this.titleRecipe = titleRecipe;
        this.imageUrl = imageUrl;
        this.isFavourite = false;
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

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
