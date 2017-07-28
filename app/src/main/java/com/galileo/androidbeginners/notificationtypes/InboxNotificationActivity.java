package com.galileo.androidbeginners.notificationtypes;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
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
        if(validInputs()){
            NotificationCompat.Builder inboxNotification =
                    new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(titleContent.getText().toString())
                    .setStyle(new NotificationCompat.InboxStyle()
                            .addLine(message1Content.getText().toString())
                            .addLine(message2Content.getText().toString())
                            .addLine(message3Content.getText().toString())
                            .setSummaryText("3 new messages")
                    );
            NotificationManager mNotificationManager =
                    (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

            // Post the notification
            mNotificationManager.notify("Nots",3, inboxNotification.build());
        }
    }
    public boolean validInputs(){
        boolean ret = true;
        if(titleContent.getText().toString().equals("")) {
            ret = false;
            title.setError("Title cannot be empty");
        }
        if (message1Content.getText().toString().equals("")){
            ret= false;
            message1.setError("Insert first message");
        }
        if (message2Content.getText().toString().equals("")){
            ret= false;
            message2.setError("Insert second message");
        }
        if (message3Content.getText().toString().equals("")){
            ret= false;
            message3.setError("Insert third message");
        }
        return ret;
    }
}
