package com.example.tasty.domain.useCases;

import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.RecipeItemsMediator;
import com.example.tasty.domain.model.RecipeItem;

public class FavouriteUpdateItemCase {
    public final RecipeItemsMediator recipeItemsMediator;
    public final FavouriteMediator favouriteMediator;

    public FavouriteUpdateItemCase(RecipeItemsMediator recipeItemsMediator, FavouriteMediator favouriteMediator) {
        this.recipeItemsMediator = recipeItemsMediator;
        this.favouriteMediator = favouriteMediator;
    }

    public void update(RecipeItem recipeItem) {
        //recipeItemsMediator.updateRecipe(recipeItem);
        favouriteMediator.updateRecipe(recipeItem.getTitleRecipe(), recipeItem.getFav());
    }
}
