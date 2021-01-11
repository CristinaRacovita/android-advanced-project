package com.example.tasty;

import android.app.Application;
import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class TastyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
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
