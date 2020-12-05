package com.example.tasty.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tasty.R;
import com.example.tasty.data.InMemoryDataSource;
import com.example.tasty.databinding.AllRecipesFragmentBinding;
import com.example.tasty.domain.RecipeItemsRepository;
import com.example.tasty.domain.useCases.FetchRecipeItemsUseCase;
import com.example.tasty.presentation.viewmodel.AllRecipesViewModel;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AllRecipesFragment extends Fragment {

    private AllRecipesViewModel mViewModel;

    public static AllRecipesFragment newInstance() {
        return new AllRecipesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.all_recipes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                RecipeItemsRepository repository = new InMemoryDataSource();
                FetchRecipeItemsUseCase useCase = new FetchRecipeItemsUseCase(repository);
                return (T) new AllRecipesViewModel(useCase);
            }
        };
        AllRecipesViewModel viewModel = new ViewModelProvider(this, factory).get(AllRecipesViewModel.class);

        AllRecipesFragmentBinding binding =
                DataBindingUtil.setContentView(Objects.requireNonNull(this.getActivity()), R.layout.all_recipes_fragment);
        binding.setAllRecipesViewModel(viewModel);
    }

}