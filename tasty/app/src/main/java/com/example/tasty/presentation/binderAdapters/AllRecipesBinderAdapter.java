package com.example.tasty.presentation.binderAdapters;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasty.domain.builders.RecipeItemBuilder;
import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.presentation.adapters.AllRecipesAdapter;
import com.example.tasty.presentation.viewmodel.RecipeItemViewModel;
import com.example.tasty.presentation.views.CookingProgressBar;

import java.util.List;
import java.util.stream.Collectors;

public class AllRecipesBinderAdapter {
    @BindingAdapter({"recipeItems", "progressBar"})
    public static void setItems(RecyclerView recyclerView, List<RecipeItemViewModel> recipeItems, CookingProgressBar progressBar) {
        RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
        progressBar.setVisibility(View.GONE);
        if (adapter == null) {
            adapter = new AllRecipesAdapter();
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        if (recipeItems != null) {
            ((AllRecipesAdapter) adapter).updateItems(recipeItems);
        }
        if(recipeItems != null) {
            //changeProgressBarVisibility(recipeItems, progressBar);
        }
    }

    private static void changeProgressBarVisibility(List<RecipeItemViewModel> items, CookingProgressBar progressBar) {
        if (items.size() == 0) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
