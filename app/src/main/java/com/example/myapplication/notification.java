package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class notification extends AppCompatActivity {
    public static final String channel_ID = "channel_id";
    private NotificationManagerCompat notificationManagerCompat;
ImageButton notif,delete;
Button b1;
EditText tv1,tv2;
Context context;
dbMain db = new dbMain(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        notif = (ImageButton)findViewById(R.id.notif);
        b1 = (Button) findViewById(R.id.dataview);
        tv1 = findViewById(R.id.view1);
        tv2 = findViewById(R.id.view2);
        notif.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                processNotify();
                shownotification();
            }
        });

    b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewData();

            }
        });
    delete = (ImageButton) findViewById(R.id.delete);
    delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            deletedata();
        }
    });
    }



    public void startDB(View view){
        new dbMain(this);
    }
    public void processNotify(){
        String view1 = tv1.getText().toString();
        String view2 = tv2.getText().toString();
        dbMain db = new dbMain(this);
        String res = db.addNotif(view1,view2);
        Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
    }
    public void  viewData(){
        Intent intent = new Intent(this,view_notif.class);
        startActivity(intent);
    }
public void deletedata() {

    Boolean deletedb = db.deleteNotif(tv1.getText().toString());

    if (deletedb == true) {
        Toast.makeText(this, "data couldnt be deleted", Toast.LENGTH_LONG).show();
    } else {
        Toast.makeText(this, "data deleted", Toast.LENGTH_LONG).show();
    }
}

public void  shownotification(){
String text = tv1.getText().toString();
Intent intent = new Intent(this,view_notif.class);
    PendingIntent content = PendingIntent.getActivity(this,0,intent,0);


    NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channel_ID);
    builder.setSmallIcon(R.drawable.ic_notificationdrawer);
    builder.setContentTitle("Fusion Tech");
    builder.setContentText(text);
    builder.setContentIntent(content);
    builder.setAutoCancel(true);
    builder.setStyle(new NotificationCompat.BigTextStyle()
            .bigText(tv2.getText().toString()));

    builder.setPriority(NotificationCompat.PRIORITY_HIGH);
    builder.setCategory(NotificationCompat.CATEGORY_MESSAGE);
    NotificationManagerCompat notificationManagerCompat =  NotificationManagerCompat.from(this);
    notificationManagerCompat.notify(1, builder.build());
}



}