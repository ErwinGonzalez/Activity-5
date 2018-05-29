package com.galileo.androidbeginners.notificationtypes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;


public class NotificationReceiver extends BroadcastReceiver {
    final static int NOTIFICATION_ID = 10001;
    final static String CHANNEL_NAME = "Channel One";
    final static String CHANNEL_ID = "30201";
    /*You can set different notification channels for each type of notification
     then, when passing a notification, you could add a parameter specifying the
      channel to be used
      */
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Default Notification Channel");
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationCompat =
                new NotificationCompat.Builder(context,CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(intent.getStringExtra("title"))
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentText((intent.getStringExtra("content")))
                ;


        // Post the notification
        assert mNotificationManager != null;
        mNotificationManager.notify(NOTIFICATION_ID, notificationCompat.build());
    }
}
