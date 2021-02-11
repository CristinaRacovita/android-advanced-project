package com.example.tasty.data.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RecipeEntity {

    @PrimaryKey
    @NonNull
    private String recipeId;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @ColumnInfo(name = "is_fav")
    private Boolean isFav;

    public RecipeEntity(String recipeId, String imageUrl, Boolean isFav) {
        this.recipeId = recipeId;
        this.imageUrl = imageUrl;
        this.isFav = isFav;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Boolean getFav() {
        return isFav;
    }
}
