package com.galileo.androidbeginners.notificationtypes;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class InboxNotificationActivity extends AppCompatActivity{
    TextInputLayout title;
    TextInputLayout message1;
    TextInputLayout message2;
    TextInputLayout message3;

    TextInputEditText titleContent;
    TextInputEditText message1Content;
    TextInputEditText message2Content;
    TextInputEditText message3Content;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox_notification);
        title = (TextInputLayout) findViewById(R.id.inboxTitleText);
        message1 = (TextInputLayout) findViewById(R.id.inboxMessage1);
        message2 = (TextInputLayout) findViewById(R.id.inboxMessage2);
        message3 = (TextInputLayout) findViewById(R.id.inboxMessage3);

        titleContent = (TextInputEditText) findViewById(R.id.titleContent);
        message1Content = (TextInputEditText) findViewById(R.id.message1Content);
        message2Content = (TextInputEditText) findViewById(R.id.message2Content);
        message3Content = (TextInputEditText) findViewById(R.id.message3Content);
    }

    public void createInboxNotification(View view) {

    }
    public boolean validInputs(){
        return true;
    }
}
