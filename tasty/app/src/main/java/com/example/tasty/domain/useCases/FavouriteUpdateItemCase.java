package com.example.tasty.domain.useCases;

import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.RecipeItemsMediator;
import com.example.tasty.domain.model.RecipeItem;

public class FavouriteUpdateItemCase {
    public final FavouriteMediator favouriteMediator;

    public FavouriteUpdateItemCase(FavouriteMediator favouriteMediator) {
        this.favouriteMediator = favouriteMediator;
    }

    public void update(RecipeItem recipeItem) {
        favouriteMediator.updateRecipe(recipeItem.getTitleRecipe(), recipeItem.getFav());
    }
}
