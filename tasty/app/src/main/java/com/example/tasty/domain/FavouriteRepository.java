package com.example.tasty.domain;

import com.example.tasty.data.RecipeItemDTO;

import java.util.List;

public interface FavouriteRepository {
    List<RecipeItemDTO> getRecipeItems();
    void insert(RecipeItemDTO recipeItemDTO);
    void deleteById(String id);
    void updateFav(String id, Boolean isFav);
}
