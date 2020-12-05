package com.example.tasty.domain.useCases;

import com.example.tasty.domain.RecipeItemsRepository;
import com.example.tasty.domain.builders.RecipeItemBuilder;
import com.example.tasty.domain.model.RecipeItem;

import java.util.List;
import java.util.stream.Collectors;

public class FetchRecipeItemsUseCase {
    public final RecipeItemsRepository recipeItemsRepository;

    public FetchRecipeItemsUseCase(RecipeItemsRepository recipeItemsRepository) {
        this.recipeItemsRepository = recipeItemsRepository;
    }

    public List<RecipeItem> getItems() {
        return recipeItemsRepository.getRecipeItems().stream().map(RecipeItemBuilder::toRecipeItem).collect(Collectors.toList());
    }
}
