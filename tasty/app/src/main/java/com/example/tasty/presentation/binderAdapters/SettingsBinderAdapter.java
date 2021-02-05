package com.example.tasty.presentation.binderAdapters;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.tasty.domain.workers.SettingsWorker;
import com.example.tasty.presentation.services.UpdateService;

import java.util.concurrent.TimeUnit;

public class SettingsBinderAdapter {
    @BindingAdapter({"workManager"})
    public static void startService(Button button, WorkManager workManager) {
        button.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(button.getContext(), UpdateService.class);
            button.getContext().stopService(serviceIntent);
            button.getContext().startService(serviceIntent);
            Toast.makeText(button.getContext(), "An update will start...", Toast.LENGTH_LONG).show();

            final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(SettingsWorker.class)
                    .setInitialDelay(60, TimeUnit.SECONDS)
                    .build();
            workManager.enqueue(oneTimeWorkRequest);

        });
    }
}
