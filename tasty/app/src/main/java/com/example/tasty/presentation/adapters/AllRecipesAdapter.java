package com.example.tasty.presentation.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasty.R;
import com.example.tasty.databinding.RecipeListItemLayoutBinding;
import com.example.tasty.domain.model.RecipeItem;

import java.util.ArrayList;
import java.util.List;

public class AllRecipesAdapter extends RecyclerView.Adapter<AllRecipesAdapter.AllRecipesViewHolder> {
    private final List<RecipeItem> itemList;

    public AllRecipesAdapter() {
        this.itemList = new ArrayList<>();
    }

    @NonNull
    @Override
    public AllRecipesAdapter.AllRecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecipeListItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.recipe_list_item_layout,
                parent,
                false);
        return new AllRecipesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllRecipesAdapter.AllRecipesViewHolder holder, int position) {
        RecipeItem item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void updateItems(List<RecipeItem> updatedList) {
        this.itemList.addAll(updatedList);
        notifyDataSetChanged();
    }

    public class AllRecipesViewHolder extends RecyclerView.ViewHolder {
        private final RecipeListItemLayoutBinding binding;

        public AllRecipesViewHolder(RecipeListItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RecipeItem model) {
            binding.setModel(model);
        }
    }
}
