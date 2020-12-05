package com.example.tasty.presentation.viewmodel;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

public class AllRecipesViewModel extends ViewModel {
    public ObservableArrayList<RecipeItem> items = new ObservableArrayList<>();

    public AllRecipesViewModel(FetchRecipeItemsUseCase fetchRecipeItemsUseCase) {
        this.items.addAll(fetchRecipeItemsUseCase.getItems());
    }
}