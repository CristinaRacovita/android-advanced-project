package com.example.tasty.data.remote;

import android.util.Log;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.domain.RecipeItemsRepository;

import java.util.Collections;
import java.util.List;

public class RemoteDataSource implements RecipeItemsRepository {
    private static final String TAG = "RemoteDataSource";
    private final RecipeAPI api;

    public RemoteDataSource(RecipeAPI api) {
        this.api = api;
    }

    @Override
    public List<RecipeItemDTO> getRecipeItems() {
        try {
            List<RecipeItemDTO> recipeItemDTOS = api.getRecipes().execute().body();
            if (recipeItemDTOS != null)
                return recipeItemDTOS;
            return Collections.emptyList();
        } catch (Exception e) {
            Log.w(TAG, "Something went wrong", e);
            return Collections.emptyList();
        }
    }
}
