package com.example.tasty.presentation.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.FavouriteAddItemUseCase;
import com.example.tasty.domain.useCases.FavouriteDeleteItemUseCase;
import com.example.tasty.domain.useCases.FavouriteFetchItemsUseCase;

import java.util.ArrayList;
import java.util.List;

public class MyRecipeViewModel extends ViewModel implements LifecycleObserver {
    public LiveData<List<RecipeItemViewModel>> items;
    public final FavouriteAddItemUseCase favouriteAddItemUseCase;
    public final FavouriteDeleteItemUseCase favouriteDeleteItemUseCase;
    public final FavouriteFetchItemsUseCase favouriteFetchItemsUseCase;

    public MyRecipeViewModel(FavouriteFetchItemsUseCase favouriteFetchItemsUseCase, FavouriteAddItemUseCase favouriteAddItemUseCase, FavouriteDeleteItemUseCase favouriteDeleteItemUseCase) {
        this.favouriteFetchItemsUseCase = favouriteFetchItemsUseCase;
        this.favouriteAddItemUseCase = favouriteAddItemUseCase;
        this.favouriteDeleteItemUseCase = favouriteDeleteItemUseCase;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreated() {
        items = Transformations.map(favouriteFetchItemsUseCase.getItems(), input -> {
            List<RecipeItemViewModel> data = new ArrayList<>();
            for (RecipeItem item : input) {
                RecipeItemViewModel viewModel = new RecipeItemViewModel(favouriteAddItemUseCase, favouriteDeleteItemUseCase);
                viewModel.liveTitle.set(item.getTitleRecipe());
                viewModel.liveUrl.set(item.getImageUrl());

                data.add(viewModel);
            }
            return data;
        });
    }

    public LiveData<List<RecipeItemViewModel>> getItems() {
        return items;
    }

    public void setItems(LiveData<List<RecipeItemViewModel>> items) {
        this.items = items;
    }

}
