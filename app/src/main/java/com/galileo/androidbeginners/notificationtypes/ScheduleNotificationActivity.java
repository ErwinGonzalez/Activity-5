package com.galileo.androidbeginners.notificationtypes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;


public class ScheduleNotificationActivity extends AppCompatActivity{
    int Hour, Minute;
    TextInputEditText title;
    TextInputEditText content;
    TextInputEditText timeset;
    TextInputLayout tlayout;
    TextInputLayout clayout;
    TextInputLayout playout;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduled_notification);
        tlayout = (TextInputLayout)findViewById(R.id.schedule_title_layout);
        clayout = (TextInputLayout)findViewById(R.id.schedule_content_layout);
        playout = (TextInputLayout)findViewById(R.id.schedule_time);

        title = (TextInputEditText)findViewById(R.id.schedule_title);
        content = (TextInputEditText)findViewById(R.id.schedule_content);
        timeset = (TextInputEditText)findViewById(R.id.schedule_time_set);
    }
    public void scheduleNotification(View view){
        if(validInputs()) {
            Calendar mcurrentTime = Calendar.getInstance();
            mcurrentTime.set(Calendar.HOUR_OF_DAY, Hour);
            mcurrentTime.set(Calendar.MINUTE, Minute);
            AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent alert = new Intent(ScheduleNotificationActivity.this, NotificationReceiver.class);
            alert.putExtra("title", title.getText().toString());
            alert.putExtra("content", content.getText().toString());
            PendingIntent pendingIntent = PendingIntent.getBroadcast(ScheduleNotificationActivity.this, 100, alert, PendingIntent.FLAG_UPDATE_CURRENT);
            manager.set(AlarmManager.RTC, mcurrentTime.getTimeInMillis(), pendingIntent);
        }
    }

    private boolean validInputs(){
        boolean ret = true;
        if(title.getText().toString().equals("")) {
            tlayout.setError("Title Cannot be Empty");
            ret = false;
        }
        if(content.getText().toString().equals("")) {
            clayout.setError("Content Cannot be Empty");
            ret = false;
        }
        if(timeset.getText().toString().equals("")) {
            playout.setError("Must pick a Time");
            ret = false;
        }
        return ret;
    }
    public void showTimePicker(View view) {
        Calendar mcurrentTime = Calendar.getInstance();
        final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        final int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(ScheduleNotificationActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                final TextInputEditText tv = (TextInputEditText) findViewById(R.id.schedule_time_set);
                Hour = selectedHour;
                Minute = selectedMinute;
                tv.setText(getString(R.string.time_set,selectedHour,selectedMinute));
            }
        }, hour, minute, true);//Yes 24 hour atime
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
}
