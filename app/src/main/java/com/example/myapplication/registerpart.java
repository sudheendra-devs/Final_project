package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class registerpart extends AppCompatActivity {
RecyclerView rec;
ArrayList<modelregister> arrayList = new ArrayList<>();
dbRegister db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpart);
    rec = findViewById(R.id.recreport);
    rec.setLayoutManager(new LinearLayoutManager(this));
        Cursor c =new dbRegister(this).readRegister();
        while(c.moveToNext()){
            modelregister obj = new modelregister(c.getString(1),c.getString(2),R.drawable.ic_register);
            arrayList.add(obj);

        }
        radapter radapter=new radapter(arrayList);
        rec.setAdapter(radapter);
    }
}