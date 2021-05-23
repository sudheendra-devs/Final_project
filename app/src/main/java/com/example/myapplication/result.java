package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {
dbvoter db;
TextView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
EditText r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
ImageButton showboi;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        showboi = findViewById(R.id.resultv);
        showboi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc1();
                sc2();
                sc3();
                sc4();
                sc5();
                sc6();
                sc7();
                sc8();
                sc9();
                sc10();
            }
        });
        a1 = findViewById(R.id.cord2);
        a2 = findViewById(R.id.cord3);
        a3 = findViewById(R.id.cord4);
        a4 = findViewById(R.id.cord5);
        a5 = findViewById(R.id.cord6);
        a6 = findViewById(R.id.cord7);
        a7 = findViewById(R.id.cord8);
        a8 = findViewById(R.id.cord9);
        a9 = findViewById(R.id.cord10);
        a10 = findViewById(R.id.cord11);
    r1 = findViewById(R.id.red1);
    r2 = findViewById(R.id.rd2);
    r3 = findViewById(R.id.red3);
    r4 = findViewById(R.id.r4);
    r5 = findViewById(R.id.r5);
    r6 = findViewById(R.id.r6);
    r7 = findViewById(R.id.r7);
    r8 = findViewById(R.id.r8);
    r9 = findViewById(R.id.r9);
    r10 = findViewById(R.id.r10);
    }
    public void sc1(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote(a1.getText().toString());
        String d = Integer.toString(c);

        r1.setText(d);
    }
    public void sc2(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote2(a2.getText().toString());
        String d = Integer.toString(c);
        r2.setText(d);
    }
    public void sc3(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote(a3.getText().toString());
        String d = Integer.toString(c);
        r3.setText(d);
    }
    public void sc4(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote2(a4.getText().toString());
        String d = Integer.toString(c);
        r4.setText(d);
    }public void sc5(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote(a5.getText().toString());
        String d = Integer.toString(c);
        r5.setText(d);
    }public void sc6(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote2(a6.getText().toString());
        String d = Integer.toString(c);
        r6.setText(d);
    }public void sc7(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote2(a7.getText().toString());
        String d = Integer.toString(c);
        r7.setText(d);
    }
    public void sc8(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote(a8.getText().toString());
        String d = Integer.toString(c);
        r8.setText(d);
    }
    public void sc9(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote(a9.getText().toString());
        String d = Integer.toString(c);
        r9.setText(d);
    }
    public void sc10(){
        dbvoter db1 = new dbvoter(this);
        int c = db1.resultvote2(a10.getText().toString());
        String d = Integer.toString(c);
        r10.setText(d);
    }



}