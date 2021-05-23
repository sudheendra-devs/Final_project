package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class clubmemadmin extends AppCompatActivity {
    private ImageButton button;
    private ImageButton report,notification,register,clubhead,vote;
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
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
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
        notification = findViewById(R.id.notifications);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotif();
            }
        });
        clubhead = findViewById(R.id.club);
        clubhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCh();
            }
        });
        vote = findViewById(R.id.vote2);
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(clubmemadmin.this, com.example.myapplication.adminvote.class);
                startActivity(intent);
            }
        });
    }
    private void openGallery(){
        Intent intent = new Intent(this,sqlgalleryadmin.class);
        startActivity(intent);
    }
    private void openReport(){
        Intent intent = new Intent(this,report.class);
        startActivity(intent);
    }
    private void openNotif(){
        Intent intent = new Intent(this,notification.class);
        startActivity(intent);
    }
    private void openRegister(){
        Intent intent = new Intent(this,registraion.class);
        startActivity(intent);
    }

    public void openCh(){
        Intent intent = new Intent(this,Clubheads.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.action_login) {

                Intent intent = new Intent(clubmemadmin.this, MainActivity2.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.action_aboutus) {
                Intent intent = new Intent(this, Aboutus.class);
                startActivity(intent);

            } else if (item.getItemId() == R.id.action_logout) {


                SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                AlertDialog.Builder builder = new AlertDialog.Builder(clubmemadmin.this)
                        .setTitle("FUSION TECH")
                        .setMessage("Do you want to logout")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(clubmemadmin.this,LoginActivity.class);
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
        return super.onOptionsItemSelected(item);
    }
}