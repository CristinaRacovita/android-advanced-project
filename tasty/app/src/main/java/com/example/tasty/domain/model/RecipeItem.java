package com.example.tasty.domain.model;

public class RecipeItem {
    private String titleRecipe;
    private int imageDrawableResource;

    public RecipeItem() {

    }

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
