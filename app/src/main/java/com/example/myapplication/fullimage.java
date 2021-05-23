package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class fullimage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        Intent i =getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapter im = new ImageAdapter(this);
        ImageView expand  = findViewById(R.id.fullboi);
        expand.setImageResource(im.pics[position]);
    }
}