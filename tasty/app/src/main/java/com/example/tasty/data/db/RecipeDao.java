package com.example.tasty.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("Select * From RecipeEntity")
    List<RecipeEntity> getRecipes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RecipeEntity recipeEntity);

    @Query("DELETE FROM RecipeEntity WHERE recipeId = :id")
    void deleteById(String id);

    @Query("Update RecipeEntity Set is_fav = :isFav Where recipeId = :id")
    void updateFav(String id, Boolean isFav);
}
