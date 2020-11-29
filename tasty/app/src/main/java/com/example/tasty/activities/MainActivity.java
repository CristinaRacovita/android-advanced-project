package com.example.tasty.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.WorkManager;

import com.example.tasty.R;
import com.example.tasty.databinding.ActivityMainBinding;
import com.example.tasty.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WorkManager.getInstance(this).pruneWork();

        MainViewModel viewModel = new MainViewModel(WorkManager.getInstance(this));
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainViewModel(viewModel);
    }
}