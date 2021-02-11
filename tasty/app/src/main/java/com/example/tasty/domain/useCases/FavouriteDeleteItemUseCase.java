package com.example.tasty.domain.useCases;

import com.example.tasty.domain.FavouriteMediator;

public class FavouriteDeleteItemUseCase {
    public final FavouriteMediator favouriteMediator;

    public FavouriteDeleteItemUseCase(FavouriteMediator favouriteMediator) {
        this.favouriteMediator = favouriteMediator;
    }

    public void deleteItem(String id) {
        favouriteMediator.deleteById(id);
    }
}
