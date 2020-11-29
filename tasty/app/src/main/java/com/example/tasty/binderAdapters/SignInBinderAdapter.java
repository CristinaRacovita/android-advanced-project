package com.example.tasty.binderAdapters;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.example.tasty.activities.MainActivity;
import com.example.tasty.viewmodel.SignInViewModel;
import com.example.tasty.workers.SignInWorker;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignInBinderAdapter {
    private static Boolean isGuest;

    @BindingAdapter({"username", "password", "usernameEditText", "passwordEditText", "errorTextView"})
    public static void check(Button button, String username, String password, EditText usernameEditText, EditText passwordEditText, TextView errorTextView) {
        button.setOnClickListener(v -> {
            Log.i(SignInViewModel.LOG_TAG, "Log in as a user");
            isGuest = false;
            Log.d(SignInViewModel.LOG_TAG + "2", "Username: " + username + " and password: " + password);
            if (username == null) {
                Log.w(SignInViewModel.LOG_TAG, "Username is null");
                usernameEditText.setError("Username cannot be empty!");
                errorTextView.setVisibility(View.INVISIBLE);
            } else if (username.isEmpty()) {
                Log.w(SignInViewModel.LOG_TAG, "Username is null");
                usernameEditText.setError("Username cannot be empty!");
                errorTextView.setVisibility(View.INVISIBLE);
            } else if (username.length() <= 5) {
                Log.w(SignInViewModel.LOG_TAG, "Username is too short");
                usernameEditText.setError("Enter at least 6 Digit username!");
                errorTextView.setVisibility(View.INVISIBLE);
            } else if (password == null) {
                Log.w(SignInViewModel.LOG_TAG, "Password is null");
                passwordEditText.setError("Password cannot be empty!");
                errorTextView.setVisibility(View.INVISIBLE);
            } else if (password.isEmpty()) {
                Log.w(SignInViewModel.LOG_TAG, "Password is null");
                passwordEditText.setError("Password cannot be empty!");
                errorTextView.setVisibility(View.INVISIBLE);
            } else if (password.length() <= 5) {
                Log.w(SignInViewModel.LOG_TAG, "Password is too short");
                passwordEditText.setError("Enter at least 6 Digit Password!");
                errorTextView.setVisibility(View.INVISIBLE);
            } else {
                //fake login
                if (username.equals("admin1234") && password.equals("admin1234")) {
                    Log.i(SignInViewModel.LOG_TAG, "Username and password is correct");
                    Intent mainIntent = new Intent(button.getContext(), MainActivity.class);
                    button.getContext().startActivity(mainIntent);
                    errorTextView.setVisibility(View.INVISIBLE);
                } else {
                    Log.w(SignInViewModel.LOG_TAG, "Username and password is incorrect");
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @BindingAdapter({"errors", "workManager"})
    public static void loginAsGuest(Button button, TextView errors, WorkManager workManager) {
        button.setOnClickListener(v -> {
            Log.i(SignInViewModel.LOG_TAG, "Log in as a guest");
            errors.setVisibility(View.INVISIBLE);
            isGuest = true;

            Log.d(SignInViewModel.LOG_TAG, "Start receive notifications");

            if (isGuest) {
                final PeriodicWorkRequest periodicWorkRequest1 = new PeriodicWorkRequest.Builder(SignInWorker.class, Duration.ofMinutes(15L))
                        .setInitialDelay(5000, TimeUnit.MILLISECONDS)
                        .build();
                workManager.enqueueUniquePeriodicWork("Receive Notification", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest1);

                Intent mainIntent = new Intent(button.getContext(), MainActivity.class);
                button.getContext().startActivity(mainIntent);
            }
        });

        if (isGuest) {
            workManager.cancelAllWork();
        }
    }


}
