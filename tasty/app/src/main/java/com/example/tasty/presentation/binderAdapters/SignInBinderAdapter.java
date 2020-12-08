package com.example.tasty.presentation.binderAdapters;

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

import com.example.tasty.domain.SignInWorker;
import com.example.tasty.presentation.activities.MainActivity;
import com.example.tasty.presentation.viewmodel.SignInViewModel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignInBinderAdapter {
    private static Boolean isGuest = false;

    @BindingAdapter({"username", "password", "usernameEditText", "passwordEditText", "errorTextView"})
    public static void check(Button button, String username, String password, EditText usernameEditText, EditText passwordEditText, TextView errorTextView) {
        button.setOnClickListener(v -> {
            Log.i(SignInViewModel.LOG_TAG, "Log in as a user");
            isGuest = false;
            Log.d(SignInViewModel.LOG_TAG + "2", "Username: " + username + " and password: " + password);
            if (username == null) {
                setAnError(usernameEditText, errorTextView, "Username is null", "Username cannot be empty!");
            } else if (username.isEmpty()) {
                setAnError(usernameEditText, errorTextView, "Username is null", "Username cannot be empty!");
            } else if (username.length() <= 5) {
                setAnError(usernameEditText, errorTextView, "Username is too short", "Enter at least 6 Digit username!");
            } else if (password == null) {
                setAnError(passwordEditText, errorTextView, "Password is null", "Password cannot be empty!");
            } else if (password.isEmpty()) {
                setAnError(passwordEditText, errorTextView, "Password is null", "Password cannot be empty!");
            } else if (password.length() <= 5) {
                setAnError(passwordEditText, errorTextView, "Password is too short", "Enter at least 6 Digit Password!");
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

    private static void setAnError(EditText usernameEditText, TextView errorTextView, String s, String s2) {
        Log.w(SignInViewModel.LOG_TAG, s);
        usernameEditText.setError(s2);
        errorTextView.setVisibility(View.INVISIBLE);
    }

    @BindingAdapter({"errors", "workManager"})
    public static void loginAsGuest(Button button, TextView errors, WorkManager workManager) {
        button.setOnClickListener(v -> {
            Log.i(SignInViewModel.LOG_TAG, "Log in as a guest");
            errors.setVisibility(View.INVISIBLE);
            isGuest = true;

            Log.d(SignInViewModel.LOG_TAG, "Start receive notifications");

            if (isGuest) {
                final PeriodicWorkRequest periodicWorkRequest1 = new PeriodicWorkRequest.Builder(SignInWorker.class, Duration.ofDays(1L))
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
