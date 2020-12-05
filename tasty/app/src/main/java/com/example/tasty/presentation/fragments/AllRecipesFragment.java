package com.example.tasty.presentation.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tasty.R;
import com.example.tasty.presentation.viewmodel.AllRecipesViewModel;

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
        mViewModel = new ViewModelProvider(this).get(AllRecipesViewModel.class);
        // TODO: Use the ViewModel
    }

}