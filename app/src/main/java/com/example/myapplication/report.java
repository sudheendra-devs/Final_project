package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Member;

public class report extends AppCompatActivity {
    private Button button,clear;
    private EditText et;
    private TextView tv;
    private static final  String EDIT = "ed1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        et = findViewById(R.id.et1);
        tv = findViewById(R.id.tv);
        String Result =et.getText().toString();

        button = (Button)findViewById(R.id.post);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Result =et.getText().toString();
                tv.setText(Result);
                Intent intent = new Intent(report.this,reportPart.class);
                intent.putExtra("tv2",Result);
                startActivity(intent);


            }
        });
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");

            }
        });


    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (outState != null){
            String saved = outState.getString(EDIT);
            tv.setText(saved);
        }
        outState.putString(EDIT,tv.getText().toString().trim());

    }
    public void save(View view){
        tv.setText(et.getText().toString().trim());
    }
}
