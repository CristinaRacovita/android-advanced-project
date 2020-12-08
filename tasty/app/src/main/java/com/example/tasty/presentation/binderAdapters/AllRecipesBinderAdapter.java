package com.example.tasty.presentation.binderAdapters;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.presentation.adapters.AllRecipesAdapter;

import java.util.List;

public class AllRecipesBinderAdapter {
    @BindingAdapter("recipeItems")
    public static void setItems(RecyclerView recyclerView, List<RecipeItem> items) {
        RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new AllRecipesAdapter();
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        if (items != null) {
            ((AllRecipesAdapter) adapter).updateItems(items);
        }
    }
}
