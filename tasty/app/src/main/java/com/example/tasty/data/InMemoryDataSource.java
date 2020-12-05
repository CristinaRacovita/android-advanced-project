package com.example.tasty.data;

import com.example.tasty.R;
import com.example.tasty.domain.RecipeItemsRepository;

import java.util.Arrays;
import java.util.List;

public class InMemoryDataSource implements RecipeItemsRepository {
    private List<RecipeItemDTO> recipeItemDTOList;

    @Override
    public List<RecipeItemDTO> getRecipeItems() {
        recipeItemDTOList = Arrays.asList(
                new RecipeItemDTO("Chicken Ranch", R.drawable.recipe_1),
                new RecipeItemDTO("Veggie & Chicken Tart", R.drawable.recipe_2),
                new RecipeItemDTO("Eggs with Spinach", R.drawable.recipe_3));
        return recipeItemDTOList;
    }
}
