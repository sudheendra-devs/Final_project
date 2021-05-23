package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup, signin;
    DBlogin DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.signup);
         signin = (Button) findViewById(R.id.signin);
         DB= new DBlogin(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity2.this,"Please Fill All The Fields",Toast.LENGTH_SHORT).show();
                else
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false)
                        {
                            Boolean insert= DB.insertData(user,pass);
                        if(insert==true) {
                            Toast.makeText(MainActivity2.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                        }
                        else
                            Toast.makeText(MainActivity2.this, "Registered Failed", Toast.LENGTH_SHORT).show();


                        }
                        else
                            Toast.makeText(MainActivity2.this, "ALREADY EXISTS", Toast.LENGTH_SHORT).show();


                    }
              else  Toast.makeText(MainActivity2.this, "Password not matching", Toast.LENGTH_SHORT).show();


            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
