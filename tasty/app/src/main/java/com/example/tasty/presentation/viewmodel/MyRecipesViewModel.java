package com.example.tasty.presentation.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.AddFavouriteUseCase;
import com.example.tasty.domain.useCases.FetchFavouriteUseCase;

import java.util.List;

public class MyRecipesViewModel extends ViewModel {
    public ObservableArrayList<RecipeItem> items = new ObservableArrayList<>();
    public ObservableField<AddFavouriteUseCase> addFavouriteUseCase= new ObservableField<>();;

    public MyRecipesViewModel(FetchFavouriteUseCase fetchFavouriteUseCase, AddFavouriteUseCase addFavouriteUseCase) {
        this.addFavouriteUseCase.set(addFavouriteUseCase);

        LiveData<List<RecipeItem>> liveRecipes = fetchFavouriteUseCase.getItems();
        if (liveRecipes != null) {
            liveRecipes.observeForever(recipeItems -> this.items.addAll(recipeItems));
        }
    }
}
