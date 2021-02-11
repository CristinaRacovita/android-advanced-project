package com.example.tasty.presentation.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.FavouriteAddItemUseCase;
import com.example.tasty.domain.useCases.FavouriteDeleteItemUseCase;
import com.example.tasty.domain.useCases.FavouriteFetchItemsUseCase;
import com.example.tasty.domain.useCases.FavouriteUpdateItemCase;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;

import java.util.ArrayList;
import java.util.List;

public class AllRecipesViewModel extends ViewModel implements LifecycleObserver {
    public LiveData<List<RecipeItemViewModel>> items;
    public final FetchRecipeItemsUseCase fetchRecipeItemsUseCase;
    public final FavouriteAddItemUseCase favouriteAddItemUseCase;
    public final FavouriteDeleteItemUseCase favouriteDeleteItemUseCase;
    public final FavouriteUpdateItemCase favouriteUpdateItemCase;
    public final FavouriteFetchItemsUseCase favouriteFetchItemsUseCase;
    public final ObservableArrayList<RecipeItem> dbItems;

    public AllRecipesViewModel(FetchRecipeItemsUseCase fetchRecipeItemsUseCase, FavouriteAddItemUseCase favouriteAddItemUseCase, FavouriteDeleteItemUseCase favouriteDeleteItemUseCase, FavouriteUpdateItemCase favouriteUpdateItemCase, FavouriteFetchItemsUseCase favouriteFetchItemsUseCase) {
        this.fetchRecipeItemsUseCase = fetchRecipeItemsUseCase;
        this.favouriteAddItemUseCase = favouriteAddItemUseCase;
        this.favouriteDeleteItemUseCase = favouriteDeleteItemUseCase;
        this.favouriteUpdateItemCase = favouriteUpdateItemCase;
        this.favouriteFetchItemsUseCase = favouriteFetchItemsUseCase;

        dbItems = new ObservableArrayList<>();

        LiveData<List<RecipeItem>> liveItems = favouriteFetchItemsUseCase.getItems();
        liveItems.observeForever(AllRecipesViewModel.this.dbItems::addAll);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreated() {
        items = Transformations.map(fetchRecipeItemsUseCase.getItems(), input -> {
            List<RecipeItemViewModel> data = new ArrayList<>();
            for (RecipeItem item : input) {
                RecipeItemViewModel viewModel = new RecipeItemViewModel(favouriteAddItemUseCase, favouriteDeleteItemUseCase, favouriteUpdateItemCase);
                viewModel.liveTitle.set(item.getTitleRecipe());
                viewModel.liveUrl.set(item.getImageUrl());
                viewModel.isFav.set(checkIfFav(item));
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

    private Boolean checkIfFav(RecipeItem recipeItem){
        if(dbItems != null) {
            for (RecipeItem item : dbItems) {
                if (item.getTitleRecipe().equals(recipeItem.getTitleRecipe())) {
                    return true;
                }
            }
        }

        return false;
    }
}