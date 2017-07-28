package com.galileo.androidbeginners.notificationtypes;

import android.app.TimePickerDialog;
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

    }

    private boolean validInputs(){
        return false;
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
