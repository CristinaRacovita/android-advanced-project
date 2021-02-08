package com.example.tasty.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.domain.builders.RecipeItemBuilder;
import com.example.tasty.domain.model.RecipeItem;

import java.util.ArrayList;
import java.util.List;

public class FavouriteMediator {
    private final FavouriteRepository favouriteRepository;
    private final MutableLiveData<List<RecipeItem>> items;

    public FavouriteMediator(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
        this.items = new MutableLiveData<>();
        this.items.setValue(new ArrayList<>());
    }

    public LiveData<List<RecipeItem>> getFavItems() {
        List<RecipeItem> items = new ArrayList<>();
        for (RecipeItemDTO recipeItemDTO : favouriteRepository.getFav()) {
            RecipeItem recipeItem = RecipeItemBuilder.toRecipeItem(recipeItemDTO);
            if (!items.contains(recipeItem)) {
                items.add(recipeItem);
            }
        }

        this.items.setValue(items);
        return this.items;
    }

    public void addFav(RecipeItem item) {
        List<RecipeItem> items = this.items.getValue();
        items.add(item);
        favouriteRepository.addFav(RecipeItemBuilder.toDTO(item));

        this.items.setValue(items);
    }
}
