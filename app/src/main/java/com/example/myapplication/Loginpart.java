package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpart extends AppCompatActivity {


            EditText username,password;
            Button login,register;
            DBlogin DB;
            CheckBox remember;




            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login3);
                username = (EditText) findViewById(R.id.username1);
                password = (EditText) findViewById(R.id.password1);
                register = findViewById(R.id.reg);
                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Loginpart.this,MainActivity2.class);
                        startActivity(intent);

                    }
                });
                login=(Button) findViewById(R.id.signin1);
                DB= new DBlogin(this);
                SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                String checkbox = sharedPreferences.getString("remember","");
                if(checkbox.equals("true"))
                {
                    Intent intent = new Intent(this,clubmem.class);
                    startActivity(intent);
                    Toast.makeText(com.example.myapplication.Loginpart.this,"WELCOME You are already signed in ",Toast.LENGTH_LONG).show();
                }
                else if(checkbox.equals("false")){
                    Toast.makeText(this,"Please sign in",Toast.LENGTH_LONG).show();
                }
                remember = findViewById(R.id.remember);
                remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(buttonView.isChecked()){
                            SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("remember", "true");
                            editor.apply();

                        }else if(!buttonView.isChecked()){
                            SharedPreferences sharedPreferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("remember","false");
                            editor.apply();

                        }
                    }
                });
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user = username.getText().toString();
                        String pass = password.getText().toString();



                        if (user.equals("") || pass.equals("") || pass.equals(""))
                            Toast.makeText(com.example.myapplication.Loginpart.this, "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
                        else {
                            Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                            if (checkuserpass == true) {
                                Toast.makeText(com.example.myapplication.Loginpart.this, "Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else
                                Toast.makeText(com.example.myapplication.Loginpart.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
