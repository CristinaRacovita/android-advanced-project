package com.example.tasty.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tasty.R;
import com.example.tasty.data.DbDataSource;
import com.example.tasty.data.db.AppDatabase;
import com.example.tasty.data.remote.RecipeAPI;
import com.example.tasty.data.remote.RemoteDataSource;
import com.example.tasty.databinding.AllRecipesFragmentBinding;
import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.FavouriteRepository;
import com.example.tasty.domain.RecipeItemsMediator;
import com.example.tasty.domain.RecipeItemsRepository;
import com.example.tasty.domain.useCases.FavouriteAddItemUseCase;
import com.example.tasty.domain.useCases.FavouriteDeleteItemUseCase;
import com.example.tasty.domain.useCases.FavouriteFetchItemsUseCase;
import com.example.tasty.domain.useCases.FavouriteUpdateItemCase;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;
import com.example.tasty.presentation.viewmodel.AllRecipesViewModel;

public class AllRecipesFragment extends Fragment {

    private View mLeak;

    public AllRecipesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                RecipeItemsRepository repository = new RemoteDataSource(RecipeAPI.createAPI());
                RecipeItemsMediator mediator = new RecipeItemsMediator(repository);
                FetchRecipeItemsUseCase useCase = new FetchRecipeItemsUseCase(mediator);

                FavouriteRepository favouriteRepository = new DbDataSource(AppDatabase.instance(AllRecipesFragment.this.getContext()).recipeDao());
                FavouriteMediator favouriteMediator = new FavouriteMediator(favouriteRepository);
                FavouriteAddItemUseCase addItemUseCase = new FavouriteAddItemUseCase(favouriteMediator);
                FavouriteDeleteItemUseCase deleteItemUseCase = new FavouriteDeleteItemUseCase(favouriteMediator);
                FavouriteUpdateItemCase favouriteUpdateItemCase = new FavouriteUpdateItemCase(mediator, favouriteMediator);
                FavouriteFetchItemsUseCase fetchItemsUseCase = new FavouriteFetchItemsUseCase(favouriteMediator);

                return (T) new AllRecipesViewModel(useCase, addItemUseCase, deleteItemUseCase, favouriteUpdateItemCase, fetchItemsUseCase);
            }
        };
        AllRecipesViewModel viewModel = new ViewModelProvider(this, factory).get(AllRecipesViewModel.class);

        AllRecipesFragmentBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.all_recipes_fragment, container, false);
        binding.setAllRecipesViewModel(viewModel);
        binding.setLifecycleOwner(this);
        getLifecycle().addObserver(viewModel);

        mLeak = binding.getRoot();
        return mLeak;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mLeak = null;
    }
}