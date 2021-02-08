package com.example.tasty.domain.builders;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.domain.model.RecipeItem;

public class RecipeItemBuilder {
    public static RecipeItem toRecipeItem(RecipeItemDTO recipeItemDTO) {
        return new RecipeItem(recipeItemDTO.getRecipeTitleId(), recipeItemDTO.getImageUrl());
    }

    public static RecipeItemDTO toDTO(RecipeItem recipeItem){
        return new RecipeItemDTO(recipeItem.getTitleRecipe(), recipeItem.getImageUrl());
    }
}
