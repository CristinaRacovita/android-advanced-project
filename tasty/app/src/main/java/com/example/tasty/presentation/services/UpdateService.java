package com.example.tasty.presentation.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.tasty.R;

public class UpdateService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationChannel channel = new NotificationChannel("update-service",
                "update processing service",
                NotificationManager.IMPORTANCE_HIGH);
        channel.setShowBadge(true);
        channel.enableVibration(true);

        Intent pendingIntent = new Intent(this, UpdateService.class);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "update-service")
                .setSmallIcon(R.drawable.ic_baseline_settings_24)
                .setCategory(NotificationCompat.CATEGORY_STATUS)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setContentTitle("Update going on")
                .setContentText("resolving bugs....")
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getService(this, 123, pendingIntent, PendingIntent.FLAG_UPDATE_CURRENT));

        startForeground(4563, builder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // unused
        return null;
    }
}
