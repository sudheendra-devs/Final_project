package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class reportPart extends AppCompatActivity {
    private TextView et2;
    Button btn;
    dbEvent db;
    RecyclerView rec;
    ArrayList<eventModel> arrayList = new ArrayList<>();
    eventAdapter adapter;
    dbEvent dbEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_part);
        rec = findViewById(R.id.recevent);
        rec.setLayoutManager(new LinearLayoutManager(this));
        Cursor c = new dbEvent(this).viewRecord();
        while (c.moveToNext()){
            eventModel obj = new eventModel(c.getString(1),c.getString(2));
            arrayList.add(obj);
        }

    eventAdapter eventAdapter = new eventAdapter(arrayList);
        rec.setAdapter(eventAdapter);

    }
}