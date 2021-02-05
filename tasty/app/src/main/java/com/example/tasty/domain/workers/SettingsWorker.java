package com.example.tasty.domain.workers;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.tasty.presentation.services.UpdateService;

public class SettingsWorker extends Worker {
    private final Intent intent;
    private final Context context;

    public SettingsWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        intent = new Intent(context, UpdateService.class);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Toast.makeText(context, "All updates are done!", Toast.LENGTH_LONG).show();
        context.stopService(intent);
        return Result.success();
    }
}
