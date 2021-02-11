package com.example.tasty.domain.useCases;

import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.model.RecipeItem;

public class FavouriteGetByIdUseCase {
    public final FavouriteMediator favouriteMediator;

    public FavouriteGetByIdUseCase(FavouriteMediator favouriteMediator) {
        this.favouriteMediator = favouriteMediator;
    }

    public RecipeItem getById(String id){
        return favouriteMediator.getById(id);
    }
}
