package com.example.notification28042021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnNotification;
    String CHANNEL_ID = "CHANNEL_APP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnNotification = findViewById(R.id.buttonNotification);

        mBtnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
                builder.setSmallIcon(android.R.drawable.star_on);
                builder.setShowWhen(true);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.hinhicon));
                builder.setContentTitle("Thông báo!!");
                builder.setPriority(Notification.PRIORITY_HIGH);
                builder.setVibrate(new long[]{1000, 1000, 1000, 1000});
                builder.setSound(Uri.parse("android.resource://" + getPackageName() +"/" + R.raw.tetdongday));
                builder.setContentText("Ứng dụng có phiên bản mới");

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = new NotificationChannel(
                            CHANNEL_ID,
                            "demo",
                            NotificationManager.IMPORTANCE_DEFAULT
                    );

                    notificationManager.createNotificationChannel(notificationChannel);
                }

                notificationManager.notify(1 , builder.build());


            }
        });
    }
}