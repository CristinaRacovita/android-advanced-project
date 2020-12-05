package com.example.tasty.presentation.activities;

import android.os.Bundle;

import com.example.tasty.R;
import com.example.tasty.databinding.ActivityMainBinding;
import com.example.tasty.presentation.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel();
            }
        };

        MainViewModel mainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setMainModel(mainViewModel);
    }
}