package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Imagedisp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedisp);
        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);
        ImageView imageView = (ImageView)findViewById(R.id.imv);
        imageView.setImageResource(adapter.pics[position]);
    }
}