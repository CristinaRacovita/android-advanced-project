package com.example.tasty.domain.builders;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.data.db.RecipeEntity;
import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.presentation.viewmodel.RecipeItemViewModel;

public class RecipeItemBuilder {
    public static RecipeItem toRecipeItem(RecipeItemDTO recipeItemDTO) {
        return new RecipeItem(recipeItemDTO.getRecipeTitleId(), recipeItemDTO.getImageUrl());
    }

    public static RecipeItemDTO toDTO(RecipeItem recipeItem) {
        return new RecipeItemDTO(recipeItem.getTitleRecipe(), recipeItem.getImageUrl());
    }

    public static RecipeEntity toEntity(RecipeItemDTO recipeItemDTO) {
        return new RecipeEntity(recipeItemDTO.getRecipeTitleId(), recipeItemDTO.getImageUrl());
    }

    public static RecipeItemDTO toDTOfromEntity(RecipeEntity recipeEntity) {
        return new RecipeItemDTO(recipeEntity.getRecipeId(), recipeEntity.getImageUrl());
    }
}

