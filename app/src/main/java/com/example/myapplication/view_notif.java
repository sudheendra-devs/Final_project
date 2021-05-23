package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class view_notif extends AppCompatActivity {
RecyclerView rec;
ArrayList<model> dataholder = new ArrayList<>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notif);
        rec= findViewById(R.id.rec1);
        rec.setLayoutManager(new LinearLayoutManager(this));
        Cursor c = new dbMain(this).viewNotif();
        while (c.moveToNext()){
            model obj = new model(c.getString(1),c.getString(2),R.drawable.ic_notif);

            dataholder.add(obj);

        }

        myAdapter adapter = new myAdapter(dataholder);
        rec.setAdapter(adapter);
        rec.setItemAnimator(new DefaultItemAnimator());
    }
}
