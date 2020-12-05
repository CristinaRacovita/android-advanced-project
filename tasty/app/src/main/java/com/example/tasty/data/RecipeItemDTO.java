package com.example.tasty.data;

public class RecipeItemDTO {
    private String titleRecipe;
    private int imageDrawableResource;

    public RecipeItemDTO() {

    }

    public RecipeItemDTO(String titleRecipe, int imageDrawableResource) {
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
