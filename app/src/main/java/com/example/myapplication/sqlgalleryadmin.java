package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.BitSet;

public class sqlgalleryadmin extends AppCompatActivity {
EditText et;
ImageView im;
ImageButton upload,add,gall;
private static final int PICK_IMAGE_REQUEST= 100;
public Uri filePath;
private Bitmap imagestore;
dbImage db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlgalleryadmin);
        db = new dbImage(this);
        et = findViewById(R.id.etimage);
        im = findViewById(R.id.disp);
        upload = findViewById(R.id.insert);
        gall = findViewById(R.id.gall);
        gall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getshow();
            }
        });
        add = findViewById(R.id.add1);
                upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chooseImage();
                    }
                });
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        storeImage();
                    }
                });
    }
    public void chooseImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.getData() !=null){
        filePath = data.getData();
            try {
                imagestore = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            im.setImageBitmap(imagestore);
        }
    }
    public void storeImage(){
        if(!et.getText().toString().isEmpty() && im.getDrawable() != null && imagestore !=null){
            db.storeImage(new modelclass(et.getText().toString(),imagestore));
            Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"add an image",Toast.LENGTH_LONG).show();
        }
    }
    public void getshow(){
        startActivity(new Intent(this,sqlgallery.class));
    }
}
