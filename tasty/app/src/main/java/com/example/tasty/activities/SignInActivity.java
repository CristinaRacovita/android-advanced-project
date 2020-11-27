package com.example.tasty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.tasty.R;
import com.example.tasty.databinding.ActivitySignInBinding;
import com.example.tasty.viewmodel.SignInViewModel;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SignInViewModel loginViewModel = new SignInViewModel();
        ActivitySignInBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        binding.setLoginViewModel(loginViewModel);
        binding.setLifecycleOwner(this);

        loginViewModel.getUser().observe(this, loginUser -> {
            if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getUsername())) {
                binding.errors.setVisibility(View.INVISIBLE);
                binding.usernameEditText.setError("Enter an username");
                binding.usernameEditText.requestFocus();
            } else if (!loginUser.isEmailValid()) {
                binding.errors.setVisibility(View.INVISIBLE);
                binding.usernameEditText.setError("Enter at least 6 Digit username");
                binding.usernameEditText.requestFocus();
            } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassword())) {
                binding.errors.setVisibility(View.INVISIBLE);
                binding.passwordEditText.setError("Enter a password");
                binding.passwordEditText.requestFocus();
            } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                binding.errors.setVisibility(View.INVISIBLE);
                binding.passwordEditText.setError("Enter at least 6 Digit password");
                binding.passwordEditText.requestFocus();
            } else {
                Log.d(SignInViewModel.LOG_TAG, "Check username and password");
                //fake login
                if (loginUser.getUsername().equals("admin1234") && loginUser.getPassword().equals("admin1234")) {
                    Intent mainIntent = new Intent(this, MainActivity.class);
                    startActivity(mainIntent);
                    binding.errors.setVisibility(View.INVISIBLE);
                } else {
                    binding.errors.setVisibility(View.VISIBLE);
                }
            }

        });

    }
}