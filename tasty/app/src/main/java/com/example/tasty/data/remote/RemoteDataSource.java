package com.example.tasty.data.remote;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.domain.RecipeItemsRepository;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

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
            Timber.tag(TAG).w(e, "Something went wrong");
            return Collections.emptyList();
        }
    }
}
