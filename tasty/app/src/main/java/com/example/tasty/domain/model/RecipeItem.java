package com.example.tasty.domain.model;

public class RecipeItem {
    private String titleRecipe;
    private String imageUrl;
    private Boolean isFav;

    public RecipeItem(String titleRecipe, String imageUrl, Boolean isFav) {
        this.titleRecipe = titleRecipe;
        this.imageUrl = imageUrl;
        this.isFav = isFav;
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

    public Boolean getFav() {
        return isFav;
    }

    public void setFav(Boolean fav) {
        isFav = fav;
    }
}
