package com.example.tasty.workers;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.tasty.R;
import com.example.tasty.viewmodel.MainViewModel;

public class MainWorker extends Worker {

    //private final TextView timerText;

    public MainWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        //timerText = (TextView) ((Activity) context).findViewById(R.id.timer_test);
        Log.d(MainViewModel.LOG_TAG, "creat");
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(MainViewModel.LOG_TAG, "facem treaba");
        //timerText.setText("15:00");
        return Result.success();
    }
}
