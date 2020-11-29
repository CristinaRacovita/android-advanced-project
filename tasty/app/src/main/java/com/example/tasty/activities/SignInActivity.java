package com.example.tasty.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.WorkManager;

import com.example.tasty.R;
import com.example.tasty.databinding.ActivitySignInBinding;
import com.example.tasty.viewmodel.SignInViewModel;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WorkManager.getInstance(this).pruneWork();
        SignInViewModel loginViewModel = new SignInViewModel(WorkManager.getInstance(this));
        ActivitySignInBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        binding.setLoginViewModel(loginViewModel);
        binding.setLifecycleOwner(this);

    }
}