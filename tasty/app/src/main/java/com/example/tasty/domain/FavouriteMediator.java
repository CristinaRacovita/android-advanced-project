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

public class FavouriteMediator {
    private final FavouriteRepository dbRepository;
    private final ExecutorService executorService;
    private final MutableLiveData<List<RecipeItem>> liveRecipes;


    public FavouriteMediator(FavouriteRepository dbRepository) {
        this.dbRepository = dbRepository;
        this.executorService = Executors.newSingleThreadExecutor();
        this.liveRecipes = new MutableLiveData<>();
    }

    public LiveData<List<RecipeItem>> getRecipes() {
        executorService.execute(() -> FavouriteMediator.this.liveRecipes.postValue(dbRepository.getRecipeItems().stream().map(RecipeItemBuilder::toRecipeItem).collect(Collectors.toList())));

        return this.liveRecipes;
    }

    public void addRecipe(RecipeItem item) {
        executorService.execute(() -> {
            dbRepository.insert(RecipeItemBuilder.toDTO(item));
            List<RecipeItem> liveRecipes = FavouriteMediator.this.liveRecipes.getValue();
            liveRecipes.add(item);

            FavouriteMediator.this.liveRecipes.setValue(liveRecipes);
        });
    }

    public void deleteById(String id) {
        executorService.execute(() -> {
            dbRepository.deleteById(id);
            List<RecipeItem> liveRecipes = FavouriteMediator.this.liveRecipes.getValue();
            Iterator<RecipeItem> iterator = liveRecipes.iterator();

            while (iterator.hasNext()) {
                if (iterator.next().getTitleRecipe().equals(id)) {
                    iterator.remove();
                }
            }

            FavouriteMediator.this.liveRecipes.setValue(liveRecipes);
        });
    }

    public RecipeItem getById(String id) {
        for (RecipeItem item : liveRecipes.getValue()) {
            if (item.getTitleRecipe().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
