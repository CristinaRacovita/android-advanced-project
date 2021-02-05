package com.example.tasty.presentation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.WorkManager;

import android.os.Bundle;

import com.example.tasty.R;
import com.example.tasty.databinding.ActivitySettingsBinding;
import com.example.tasty.presentation.viewmodel.SettingsViewModel;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new SettingsViewModel(WorkManager.getInstance(SettingsActivity.this));
            }
        };

        SettingsViewModel settingsViewModel = new ViewModelProvider(this, factory).get(SettingsViewModel.class);

        ActivitySettingsBinding activitySettingsBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        activitySettingsBinding.setSettingsModel(settingsViewModel);

    }
}