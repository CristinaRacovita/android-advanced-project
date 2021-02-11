package com.example.tasty.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tasty.domain.builders.RecipeItemBuilder;
import com.example.tasty.domain.model.RecipeItem;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class RecipeItemsMediator {
    private final RecipeItemsRepository remoteRepository;
    private final ExecutorService executorService;
    private final MutableLiveData<List<RecipeItem>> liveRecipes;

    public RecipeItemsMediator(RecipeItemsRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
        this.executorService = Executors.newSingleThreadExecutor();
        this.liveRecipes = new MutableLiveData<>();
    }

    public LiveData<List<RecipeItem>> getRecipes() {
        executorService.execute(() -> {
            this.liveRecipes.postValue(remoteRepository.getRecipeItems().stream().map(RecipeItemBuilder::toRecipeItem).collect(Collectors.toList()));
        });

        return liveRecipes;
    }
}
