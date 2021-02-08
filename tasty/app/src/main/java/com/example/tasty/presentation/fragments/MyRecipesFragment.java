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
import com.example.tasty.data.FavouriteInMemoryDataSource;
import com.example.tasty.databinding.FragmentMyRecipesBinding;
import com.example.tasty.domain.FavouriteMediator;
import com.example.tasty.domain.FavouriteRepository;
import com.example.tasty.domain.useCases.AddFavouriteUseCase;
import com.example.tasty.domain.useCases.FetchFavouriteUseCase;
import com.example.tasty.presentation.viewmodel.MyRecipesViewModel;

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
                FavouriteRepository repository = new FavouriteInMemoryDataSource();
                FavouriteMediator mediator = new FavouriteMediator(repository);
                FetchFavouriteUseCase useCase = new FetchFavouriteUseCase(mediator);
                AddFavouriteUseCase useCase1 = new AddFavouriteUseCase(mediator);
                return (T) new MyRecipesViewModel(useCase,useCase1);
            }
        };
        MyRecipesViewModel viewModel = new ViewModelProvider(this, factory).get(MyRecipesViewModel.class);
        FragmentMyRecipesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_recipes, container, false);
        binding.setFavViewModel(viewModel);

        return binding.getRoot();
    }
}