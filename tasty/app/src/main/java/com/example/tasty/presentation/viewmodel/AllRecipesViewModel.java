package com.example.tasty.presentation.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;

import java.util.List;

public class AllRecipesViewModel extends ViewModel {
    public ObservableArrayList<RecipeItem> items = new ObservableArrayList<>();

    public AllRecipesViewModel(FetchRecipeItemsUseCase fetchRecipeItemsUseCase) {
        LiveData<List<RecipeItem>> liveRecipes = fetchRecipeItemsUseCase.getItems();
        if(liveRecipes != null ) {
            liveRecipes.observeForever(recipeItems -> this.items.addAll(recipeItems));
        }
    }
}