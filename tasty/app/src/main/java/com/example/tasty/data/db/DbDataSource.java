package com.example.tasty.data.db;

import com.example.tasty.data.RecipeItemDTO;
import com.example.tasty.domain.FavouriteRepository;
import com.example.tasty.domain.builders.RecipeItemBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class DbDataSource implements FavouriteRepository {
    private final RecipeDao dao;

    public DbDataSource(RecipeDao dao) {
        this.dao = dao;
    }

    @Override
    public List<RecipeItemDTO> getRecipeItems() {
        return dao.getRecipes().stream().map(RecipeItemBuilder::toDTOfromEntity).collect(Collectors.toList());
    }

    @Override
    public void insert(RecipeItemDTO recipeItemDTO) {
        dao.insert(RecipeItemBuilder.toEntity(recipeItemDTO));
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }

    @Override
    public void updateFav(String id, Boolean isFav) {
        dao.updateFav(id, isFav);
    }
}
