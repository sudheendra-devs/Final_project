package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class clubmemadmin extends AppCompatActivity {
    private ImageButton button;
    private ImageButton report;
    private int[] mImages= new int[]{
            R.drawable.img3, R.drawable.img4, R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clubmem);
        CarouselView carouselview = findViewById(R.id.car);
        carouselview.setPageCount(mImages.length);
        carouselview.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        carouselview.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(clubmemadmin.this, mImages[position], Toast.LENGTH_SHORT).show();
            }
        });
        button =(ImageButton) findViewById(R.id.gal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        report = findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReport();
            }
        });
    }
    private void openGallery(){
        Intent intent = new Intent(this,galleryadmin.class);
        startActivity(intent);
    }
    private void openReport(){
        Intent intent = new Intent(this,report.class);
        startActivity(intent);
    }

}