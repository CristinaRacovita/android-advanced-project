package com.example.tasty.domain.useCases;

import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.model.RecipeItem;

public class AddFavouriteUseCase {
    private final FavouriteMediator favouriteMediator;

    public AddFavouriteUseCase(FavouriteMediator favouriteMediator) {
        this.favouriteMediator = favouriteMediator;
    }

    public void addItem(String title, String url) {
        RecipeItem item = new RecipeItem(title, url);
        favouriteMediator.addFav(item);
    }
}
