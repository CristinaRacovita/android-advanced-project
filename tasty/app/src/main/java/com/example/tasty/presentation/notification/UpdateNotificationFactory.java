package com.example.tasty.presentation.notification;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationCompat;

public class UpdateNotificationFactory {

    public static Notification createUpdateNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, UpdateNotificationChannelFactory.CHANNEL_ID)
                .setSmallIcon(android.R.drawable.star_on)
                .setCategory(NotificationCompat.CATEGORY_STATUS)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setContentTitle("App Update")
                .setChannelId(UpdateNotificationChannelFactory.CHANNEL_ID)
                .setContentText("update..update..update..")
                .setAutoCancel(true);

        return builder.build();
    }
}
