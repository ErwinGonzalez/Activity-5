package com.galileo.androidbeginners.notificationtypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*TODO create the notification receiver, either one for all three or one for each
      the ic_launcher icon in this project is non-adaptive, meaning you can safely
       use it when sending notifications in Android O.
       Always be sure to check  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startSchedule(View view){
        startActivity(new Intent(this,ScheduleNotificationActivity.class));
    }
    public void startBig(View view){
        startActivity(new Intent(this,BigNotificationActivity.class));
    }
    public void startInbox(View view){
        startActivity(new Intent(this,InboxNotificationActivity.class));
    }
}
