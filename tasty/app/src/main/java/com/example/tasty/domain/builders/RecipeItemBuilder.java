package com.example.tasty.domain.builders;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.data.db.RecipeEntity;
import com.example.tasty.domain.model.RecipeItem;

public class RecipeItemBuilder {
    public static RecipeItem toRecipeItem(RecipeItemDTO recipeItemDTO) {
        return new RecipeItem(recipeItemDTO.getRecipeTitleId(), recipeItemDTO.getImageUrl(), recipeItemDTO.getFav());
    }

    public static RecipeItemDTO toDTO(RecipeItem recipeItem) {
        return new RecipeItemDTO(recipeItem.getTitleRecipe(), recipeItem.getImageUrl(), recipeItem.getFav());
    }

    public static RecipeEntity toEntity(RecipeItemDTO recipeItemDTO) {
        return new RecipeEntity(recipeItemDTO.getRecipeTitleId(), recipeItemDTO.getImageUrl(), recipeItemDTO.getFav());
    }

    public static RecipeItemDTO toDTOfromEntity(RecipeEntity recipeEntity) {
        return new RecipeItemDTO(recipeEntity.getRecipeId(), recipeEntity.getImageUrl(), recipeEntity.getFav());
    }
}

