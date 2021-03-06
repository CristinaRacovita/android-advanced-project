package com.example.tasty.domain.useCases;

import androidx.lifecycle.LiveData;

import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.model.RecipeItem;

import java.util.List;

public class FavouriteFetchItemsUseCase {
    public final FavouriteMediator favouriteMediator;

    public FavouriteFetchItemsUseCase(FavouriteMediator favouriteMediator) {
        this.favouriteMediator = favouriteMediator;
    }


    public LiveData<List<RecipeItem>> getItems() {
        return favouriteMediator.getRecipes();
    }
}
