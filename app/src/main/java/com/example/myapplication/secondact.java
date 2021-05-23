package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondact extends AppCompatActivity {
    private Button button;
    private  Button button2;
    private EditText text1;
    String correct_pass="1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondact);
        button=(Button) findViewById(R.id.reset);
        button2=(Button)findViewById(R.id.enterkey);
        EditText text1 = (EditText)findViewById(R.id.text1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               text1.setText("");
                
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(text1.getText().toString().equals(correct_pass))
               {
                   Toast.makeText(secondact.this,"Success",Toast.LENGTH_LONG).show();
                  openclubmem();
               }
               else
               {
                   Toast.makeText(secondact.this,"enter correct password",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
    public void openclubmem()
    {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }



}