package com.example.tasty.data;

import com.example.tasty.domain.FavouriteRepository;

import java.util.ArrayList;
import java.util.List;

public class FavouriteInMemoryDataSource implements FavouriteRepository {
    private final List<RecipeItemDTO> data;

    public FavouriteInMemoryDataSource() {
        this.data = new ArrayList<>();
    }

    @Override
    public List<RecipeItemDTO> getFav() {
        return data;
    }

    @Override
    public void addFav(RecipeItemDTO recipeItem) {
        if (!data.contains(recipeItem)) {
            data.add(recipeItem);
        }
    }
}
