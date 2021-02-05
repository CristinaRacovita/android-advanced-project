package com.example.tasty;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.example.tasty.presentation.notification.UpdateNotificationChannelFactory;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class TastyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        do_setup();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(UpdateNotificationChannelFactory.createProcessingWorkNotificationChannel());
        }
    }

    private void do_setup() {
        if (!BuildConfig.my_flag) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
                    if (priority < Log.INFO) {
                        return;
                    }

                    if (t != null) {
                        FirebaseCrashlytics.getInstance().recordException(t);
                    }

                    String crashlyticsMessage = String.format("[%s] %s", tag, message);
                    FirebaseCrashlytics.getInstance().log(crashlyticsMessage);
                }
            });
        }
    }

}
