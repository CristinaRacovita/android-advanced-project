package com.example.tasty.domain;

import com.example.tasty.data.RecipeItemDTO;

import java.util.List;

public interface FavouriteRepository {
    List<RecipeItemDTO> getFav();

    void addFav(RecipeItemDTO recipeItem);
}
