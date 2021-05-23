package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class registraion extends AppCompatActivity {
    ImageButton post, delete, register;
    EditText name1, link1;
    dbRegister db = new dbRegister(this);
    public static final String channel2 = "Channel_id";
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion);
notificationManagerCompat = NotificationManagerCompat.from(this);
        link1 = findViewById(R.id.link);
        name1 = findViewById(R.id.name);
        post = findViewById(R.id.postit);
        delete = findViewById(R.id.deleteit);
        register = findViewById(R.id.registerit);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();


            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processdelete();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openData();
            }
        });
    }

    public void startDB(View view) {
        new dbRegister(this);
    }

    public void processinsert() {
        String l = link1.getText().toString();
        String n = name1.getText().toString();
        dbRegister db = new dbRegister(this);
        String res = db.addRegister(n,l);
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
      AlertDialog.Builder builder = new AlertDialog.Builder(registraion.this)
              .setTitle("FUSION TECH")
              .setMessage("Do you want to post this registraion on notification board")
              .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(registraion.this,notification.class);
                    startActivity(intent);
                  }
              })
              .setNegativeButton("No", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                  }
              });
      AlertDialog alertDialog = builder.create();
      alertDialog.show();
    }
    public Boolean processdelete() {

        Boolean deletedb = db.deleteRegister(name1.getText().toString());

        if (deletedb == true) {
            Toast.makeText(this, "data couldnt be deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "data deleted", Toast.LENGTH_LONG).show();
        }
        return  null;
}


    public void openData(){
        Intent intent = new Intent(this,registerpart.class);
        startActivity(intent);

    }


    }
