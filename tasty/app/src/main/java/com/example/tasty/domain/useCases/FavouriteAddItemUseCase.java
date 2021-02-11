package com.example.tasty.domain.useCases;

import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.model.RecipeItem;

public class FavouriteAddItemUseCase {
    public final FavouriteMediator favouriteMediator;

    public FavouriteAddItemUseCase(FavouriteMediator favouriteMediator) {
        this.favouriteMediator = favouriteMediator;
    }

    public void addItem(RecipeItem recipeItem) {
        favouriteMediator.addRecipe(recipeItem);
    }
}
