package com.example.tasty.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tasty.R;
import com.example.tasty.data.DbDataSource;
import com.example.tasty.data.db.AppDatabase;
import com.example.tasty.data.remote.RecipeAPI;
import com.example.tasty.data.remote.RemoteDataSource;
import com.example.tasty.databinding.FragmentMyRecipesBinding;
import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.FavouriteRepository;
import com.example.tasty.domain.RecipeItemsMediator;
import com.example.tasty.domain.RecipeItemsRepository;
import com.example.tasty.domain.useCases.FavouriteAddItemUseCase;
import com.example.tasty.domain.useCases.FavouriteDeleteItemUseCase;
import com.example.tasty.domain.useCases.FavouriteFetchItemsUseCase;
import com.example.tasty.domain.useCases.FavouriteGetByIdUseCase;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;
import com.example.tasty.presentation.viewmodel.MyRecipeViewModel;

public class MyRecipesFragment extends Fragment {
    public MyRecipesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                FavouriteRepository repository = new DbDataSource(AppDatabase.instance(MyRecipesFragment.this.getContext()).recipeDao());
                FavouriteMediator mediator = new FavouriteMediator(repository);
                FavouriteFetchItemsUseCase fetchItemsUseCase = new FavouriteFetchItemsUseCase(mediator);
                FavouriteAddItemUseCase addItemUseCase = new FavouriteAddItemUseCase(mediator);
                FavouriteDeleteItemUseCase deleteItemUseCase = new FavouriteDeleteItemUseCase(mediator);

                return (T) new MyRecipeViewModel(fetchItemsUseCase, addItemUseCase, deleteItemUseCase);
            }
        };
        MyRecipeViewModel viewModel = new ViewModelProvider(this, factory).get(MyRecipeViewModel.class);
        FragmentMyRecipesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_recipes, container, false);
        binding.setFavViewModel(viewModel);
        binding.setLifecycleOwner(this);
        getLifecycle().addObserver(viewModel);

        return binding.getRoot();
    }
}