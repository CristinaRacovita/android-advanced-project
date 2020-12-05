package com.example.tasty.domain;

import com.example.tasty.data.RecipeItemDTO;

import java.util.List;

public interface RecipeItemsRepository {
    public List<RecipeItemDTO> getRecipeItems();
}
