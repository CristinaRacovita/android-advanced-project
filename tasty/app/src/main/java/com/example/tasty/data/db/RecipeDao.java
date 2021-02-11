package com.example.tasty.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("Select * From RecipeEntity")
    List<RecipeEntity> getRecipes();

    @Insert
    void insert(RecipeEntity recipeEntity);

    @Query("DELETE FROM RecipeEntity WHERE recipeId = :id")
    void deleteById(String id);

    @Query("SELECT * FROM RecipeEntity Where recipeId = :id")
    RecipeEntity getById(String id);
}
