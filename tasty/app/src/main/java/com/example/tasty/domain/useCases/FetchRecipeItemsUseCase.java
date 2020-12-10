package com.example.tasty.domain.useCases;

import androidx.lifecycle.LiveData;

import com.example.tasty.domain.RecipeItemsMediator;
import com.example.tasty.domain.model.RecipeItem;

import java.util.List;

public class FetchRecipeItemsUseCase {
    public final RecipeItemsMediator recipeItemsMediator;

    public FetchRecipeItemsUseCase(RecipeItemsMediator recipeItemsMediator) {
        this.recipeItemsMediator = recipeItemsMediator;
    }


    public LiveData<List<RecipeItem>> getItems() {
        return recipeItemsMediator.getRecipes();
    }
}
