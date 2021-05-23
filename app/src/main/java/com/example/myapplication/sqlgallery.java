package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class sqlgallery extends AppCompatActivity {
    dbImage db;
    RecyclerView rec;
    showAdapter sp;
    Button show;
    ArrayList<modelclass> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlgallery);
        rec = findViewById(R.id.rec2);
        db = new dbImage(this);
        show = findViewById(R.id.show);

        
    }

    public void getData(View v){
            sp = new showAdapter(db.getAllImagesData());
            rec.setHasFixedSize(true);
            rec.setLayoutManager(new LinearLayoutManager(this));
            rec.setAdapter(sp);
        }
    }