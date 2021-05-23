package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class start extends AppCompatActivity {
Timer timer;
int drawable[],last ,randonnum ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        drawable = new int[]{
                R.drawable.mainboi,R.drawable.image1,R.drawable.image88,R.drawable.boi
        };
        View view = findViewById(R.id.bgm);
        int arraylenght = drawable.length;
        Random random = new Random();
        last = randonnum;
        do{
            randonnum = random.nextInt(arraylenght);
        }while(randonnum == last);
        last = randonnum;
        view.setBackground(ContextCompat.getDrawable(getApplicationContext(),drawable[randonnum]));
     timer = new Timer();
     timer.schedule(new TimerTask() {
         @Override
         public void run() {
             Intent intent = new Intent(start.this,MainActivity.class);
             startActivity(intent);
         }
     },3000);
    }
}