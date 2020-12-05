package com.example.tasty.presentation.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.WorkManager;

import com.example.tasty.R;

import com.example.tasty.databinding.ActivitySignInBinding;
import com.example.tasty.presentation.viewmodel.SignInViewModel;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WorkManager.getInstance(this).pruneWork();

        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new SignInViewModel(WorkManager.getInstance(SignInActivity.this));
            }
        };

        SignInViewModel loginViewModel = new ViewModelProvider(this, factory).get(SignInViewModel.class);


        ActivitySignInBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        binding.setLoginViewModel(loginViewModel);
        //binding.setLifecycleOwner(this);

    }
}