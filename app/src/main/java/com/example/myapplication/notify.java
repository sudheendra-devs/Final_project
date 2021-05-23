package com.example.myapplication;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class notify extends Application {
    public static final String Channel_1 = "channel1";
    public static final String Channel_2 = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    public void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(Channel_1, "channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is to channel 1");
            NotificationChannel channel2 = new NotificationChannel(Channel_2, "channel 2", NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("This is to channel 2");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);




        }
    }

}


