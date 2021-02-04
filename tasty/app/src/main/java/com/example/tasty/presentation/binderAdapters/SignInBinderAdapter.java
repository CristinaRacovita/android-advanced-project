package com.example.tasty.presentation.binderAdapters;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.example.tasty.R;
import com.example.tasty.domain.SignInWorker;
import com.example.tasty.presentation.activities.MainActivity;
import com.example.tasty.presentation.viewmodel.SignInViewModel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;

public class SignInBinderAdapter {
    private static Boolean isGuest = false;

    @BindingAdapter({"username", "password", "usernameEditText", "passwordEditText", "errorTextView"})
    public static void check(Button button, String username, String password, EditText usernameEditText, EditText passwordEditText, TextView errorTextView) {
        button.setOnClickListener(v -> {
            //throw new RuntimeException("Crash Trash");
            Timber.i("Log in as a user");
            isGuest = false;
            Timber.d("Username: " + username + " and password: " + password);
            if (username == null) {
                setAnError(usernameEditText, errorTextView, button.getContext().getString(R.string.user_null), button.getContext().getString(R.string.user_empty));
            } else if (username.isEmpty()) {
                setAnError(usernameEditText, errorTextView, button.getContext().getString(R.string.user_null), button.getContext().getString(R.string.user_empty));
            } else if (username.length() <= 5) {
                setAnError(usernameEditText, errorTextView, button.getContext().getString(R.string.username_too_short), button.getContext().getString(R.string.enter_character));
            } else if (password == null) {
                setAnError(passwordEditText, errorTextView, button.getContext().getString(R.string.pass_null), button.getContext().getString(R.string.pass_empty));
            } else if (password.isEmpty()) {
                setAnError(passwordEditText, errorTextView, button.getContext().getString(R.string.pass_null), button.getContext().getString(R.string.pass_empty));
            } else if (password.length() <= 5) {
                setAnError(passwordEditText, errorTextView, button.getContext().getString(R.string.pass_too_short), button.getContext().getString(R.string.pass_character));
            } else {
                login(button, username, password, errorTextView);
            }
        });
    }

    private static void login(Button button, String username, String password, TextView errorTextView) {
        if (username.equals("admin1234") && password.equals("admin1234")) {
            Timber.i("Username and password is correct");
            Intent mainIntent = new Intent(button.getContext(), MainActivity.class);
            button.getContext().startActivity(mainIntent);
            errorTextView.setVisibility(View.INVISIBLE);
        } else {
            Timber.tag(SignInViewModel.LOG_TAG).w("Username and password is incorrect");
            errorTextView.setVisibility(View.VISIBLE);
        }
    }

    private static void setAnError(EditText usernameEditText, TextView errorTextView, String s, String s2) {
        Timber.tag(SignInViewModel.LOG_TAG).w(s);
        usernameEditText.setError(s2);
        errorTextView.setVisibility(View.INVISIBLE);
    }

    @BindingAdapter({"errors", "workManager"})
    public static void loginAsGuest(Button button, TextView errors, WorkManager workManager) {
        button.setOnClickListener(v -> {
            Timber.i("Log in as a guest");
            errors.setVisibility(View.INVISIBLE);
            isGuest = true;

            Timber.d("Start receive notifications");

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
