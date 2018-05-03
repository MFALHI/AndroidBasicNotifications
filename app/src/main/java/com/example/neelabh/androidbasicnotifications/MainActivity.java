package com.example.neelabh.androidbasicnotifications;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "channel";
    public static final int notificationId = 1;

    String textTitle;
    String textContent;
    String subText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view){

        textTitle = getApplicationContext().getString(R.string.app_notification_title);
        textContent = getApplicationContext().getString(R.string.app_notification_text);
        subText = getApplicationContext().getString(R.string.app_notification_subtext);

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://developer.android.com/reference/android/app/Notification.html"));

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setSubText(subText)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(notificationId,mBuilder.build());

    }
}
