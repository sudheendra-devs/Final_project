package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class adminvote extends AppCompatActivity {
ImageButton adddata,show111,delboi;
EditText sc1,sc2,p1,p2,f1,f2,t1,t2,l1,l2;
String st;
Dbvote db;
dbvoter db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminvote);
        sc1 = findViewById(R.id.sc1);
        sc2 = findViewById(R.id.sc2);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        delboi = findViewById(R.id.del);
        delboi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteview();
            }
        });
        show111 = findViewById(R.id.viewbro);
        show111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewinfo();
            }
        });
        adddata  = findViewById(R.id.adddata);
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addinfo();
            }
        });
    }
    public void startDB(View view){
        new Dbvote(this);
    }
    public void addinfo(){
        String s1 = sc1.getText().toString();
        String s2 = sc2.getText().toString();
        String pp1 = p1.getText().toString();
        String pp2 = p2.getText().toString();
        String ff1 = f1.getText().toString();
        String ff2 = f2.getText().toString();
        String ll1 = l1.getText().toString();
        String ll2 = l2.getText().toString();
        String tt1 = t1.getText().toString();
        String tt2 = t2.getText().toString();
        db = new Dbvote(this);
    String res = db.addVote(s1,s2,pp1,pp2,ff1,ff2,ll1,ll2,tt1,tt2);
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show();


    }
    public void viewinfo(){
        Intent intent = new Intent(this,result.class);
        startActivity(intent);

        }
public void deleteview(){
        db = new Dbvote(this);
     boolean r = db.deletevote(sc1.getText().toString());
    if(r == true){
        Toast.makeText(this,"deleted",Toast.LENGTH_LONG).show();
    }
    else{
        Toast.makeText(this," not deleted",Toast.LENGTH_LONG).show();
    }
}
}

