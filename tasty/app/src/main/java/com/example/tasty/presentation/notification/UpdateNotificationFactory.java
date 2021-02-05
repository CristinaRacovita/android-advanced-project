package com.example.tasty.presentation.notification;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationCompat;

import com.example.tasty.R;

public class UpdateNotificationFactory {

    public static Notification createUpdateNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, UpdateNotificationChannelFactory.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_settings_24)
                .setCategory(NotificationCompat.CATEGORY_STATUS)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setContentTitle("App Update")
                .setContentText("update..update..update..")
                .setAutoCancel(true);

        return builder.build();
    }
}
