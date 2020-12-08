package com.example.tasty.presentation.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;

public class AllRecipesViewModel extends ViewModel {
    public ObservableArrayList<RecipeItem> items = new ObservableArrayList<>();

    public AllRecipesViewModel(FetchRecipeItemsUseCase fetchRecipeItemsUseCase) {
        this.items.addAll(fetchRecipeItemsUseCase.getItems());
    }
}