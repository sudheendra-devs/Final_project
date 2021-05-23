package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class report extends AppCompatActivity {
  ImageButton button,clear,view;
     EditText et;
     TextView tv;

    dbEvent db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        et = findViewById(R.id.et1);
        tv = findViewById(R.id.headtv);
        view = findViewById(R.id.viewevent);
        db = new dbEvent(this);
        button = findViewById(R.id.post);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addResult();
                AlertDialog.Builder builder = new AlertDialog.Builder(report.this)
                        .setTitle("FUSION TECH")
                        .setMessage("Do you want to post this registraion on notification board")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(report.this,notification.class);
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
        });
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            deleteRecord();

            }
        });
    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            viewevent();
        }
    });

    }
    public void startDB(View view){
        new DbHelper(this);
    }
    public void addResult(){
        String l =et.getText().toString();
        String n = tv.getText().toString();
         db = new dbEvent(this);
        String res = db.addRecord(n,l);
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();

    }
public void viewevent(){
        Intent intent = new Intent(this,reportPart.class);
        startActivity(intent);
}
public void deleteRecord(){

    boolean  delete= db.deleteRecord(tv.getText().toString());

    if(delete == true){
        Toast.makeText(report.this,"data deleted",Toast.LENGTH_LONG).show();
    }
    else{
        Toast.makeText(report.this,"data couldnt be deleted",Toast.LENGTH_LONG).show();
    }

}
}
