package com.example.tasty.activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;

import com.example.tasty.R;
import com.example.tasty.databinding.ActivitySignInBinding;
import com.example.tasty.viewmodel.SignInViewModel;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SignInViewModel loginViewModel = new SignInViewModel();
        ActivitySignInBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        binding.setLoginViewModel(loginViewModel);
        binding.setLifecycleOwner(this);

        loginViewModel.getUser().observe(this, loginUser -> {
            if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getUsername())) {
                Log.w(SignInViewModel.LOG_TAG, "Username is null");
                binding.errors.setVisibility(View.INVISIBLE);
                binding.usernameEditText.setError("Enter an username");
                binding.usernameEditText.requestFocus();
            } else if (!loginUser.isEmailValid()) {
                Log.w(SignInViewModel.LOG_TAG, "Username is invalid");
                binding.errors.setVisibility(View.INVISIBLE);
                binding.usernameEditText.setError("Enter at least 6 Digit username");
                binding.usernameEditText.requestFocus();
            } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassword())) {
                Log.w(SignInViewModel.LOG_TAG, "Password is null");
                binding.errors.setVisibility(View.INVISIBLE);
                binding.passwordEditText.setError("Enter a password");
                binding.passwordEditText.requestFocus();
            } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                Log.w(SignInViewModel.LOG_TAG, "Password is invalid");
                binding.errors.setVisibility(View.INVISIBLE);
                binding.passwordEditText.setError("Enter at least 6 Digit password");
                binding.passwordEditText.requestFocus();
            } else {
                Log.d(SignInViewModel.LOG_TAG, "Username and password is valid");
                Log.d(SignInViewModel.LOG_TAG, "Check username and password");
                //fake login
                if (loginUser.getUsername().equals("admin1234") && loginUser.getPassword().equals("admin1234")) {
                    Log.i(SignInViewModel.LOG_TAG, "Username and password is correct");
                    Intent mainIntent = new Intent(this, MainActivity.class);
                    startActivity(mainIntent);
                    binding.errors.setVisibility(View.INVISIBLE);
                } else {
                    Log.w(SignInViewModel.LOG_TAG, "Username and password is incorrect");
                    binding.errors.setVisibility(View.VISIBLE);
                }
            }

        });

        loginViewModel.getIsGuest().observe(this, aBoolean -> {
            if (aBoolean) {
                Log.i(SignInViewModel.LOG_TAG, "Log in as guest");

                binding.errors.setVisibility(View.INVISIBLE);

                Log.d(SignInViewModel.LOG_TAG, "Create notification");

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext(), "notify_001");

                Intent intent = new Intent();
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                mBuilder.setContentIntent(pendingIntent);
                mBuilder.setSmallIcon(R.drawable.ic_warning);
                mBuilder.setContentTitle("You're logged as a guest!");
                mBuilder.setContentText("Your data is in danger! We suggest you to login with username and password!");
                mBuilder.setPriority(Notification.PRIORITY_MAX);

                mNotificationManager =
                        (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    String channelId = "Your_channel_id";
                    NotificationChannel channel = new NotificationChannel(
                            channelId,
                            "My Channel",
                            NotificationManager.IMPORTANCE_HIGH);
                    mNotificationManager.createNotificationChannel(channel);
                    mBuilder.setChannelId(channelId);
                }

                mNotificationManager.notify(0, mBuilder.build());
                Log.d(SignInViewModel.LOG_TAG, "Notification was created");

                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });

    }
}