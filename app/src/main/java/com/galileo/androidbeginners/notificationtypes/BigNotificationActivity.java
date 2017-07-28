package com.galileo.androidbeginners.notificationtypes;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;


public class BigNotificationActivity extends AppCompatActivity{

    TextInputEditText title;
    TextInputEditText content;
    TextInputLayout tlayout;
    TextInputLayout clayout;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_notification);
        tlayout = (TextInputLayout)findViewById(R.id.bigTitleLayout);
        clayout = (TextInputLayout)findViewById(R.id.bigContentLayout);
        title = (TextInputEditText)findViewById(R.id.bigEditTitle);
        content = (TextInputEditText)findViewById(R.id.bigEditText);
    }

    public void createBigNotification(View view){

    }

    private boolean validInput() {
        return false;
    }
}
