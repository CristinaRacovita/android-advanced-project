package com.example.tasty.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.tasty.workers.MainWorker;

public class MainViewModel extends ViewModel {

    public static final String LOG_TAG = "MainActivity";
    private final WorkManager workManager;

    public MainViewModel(WorkManager workManager) {
        this.workManager = workManager;
    }

    public void count() {
        Log.d(LOG_TAG, "Timer button was hit!");

        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MainWorker.class).build();
        workManager.beginUniqueWork("count-work", ExistingWorkPolicy.APPEND, request).enqueue();
    }
}
