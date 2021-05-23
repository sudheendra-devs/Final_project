package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tech extends AppCompatActivity {
    int count = 0;
    RadioGroup rg;
    RadioButton btnst1;
    RadioButton btnst2;
    TextView s1;
    TextView s2;
    TextView st1;
    TextView st2;
    Dbvote db;
    dbvoter db1;
    ImageButton viewer, vote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);
        rg = (RadioGroup) findViewById(R.id.rg);
        viewer = findViewById(R.id.viewer);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        st1 = findViewById(R.id.st1count);
        vote = findViewById(R.id.voteboi);

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        st2 = findViewById(R.id.st2count);
        rg = findViewById(R.id.rg);
        btnst1 = findViewById(R.id.rdb1);
        btnst2 = findViewById(R.id.rdb2);
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteee();

            }
        });
        viewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = new Dbvote(getApplicationContext()).t1();
                if (c.moveToNext()) {
                    s1.setText(c.getString(0));
                    s2.setText(c.getString(1));
                    btnst1.setText(c.getString(0));
                    btnst2.setText(c.getString(1));

                }
            }
        });
        btnst1.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                int selectedid = rg.getCheckedRadioButtonId();
                btnst1 = (RadioButton) findViewById(selectedid);
                btnst2 = (RadioButton) findViewById(selectedid);

                btnst1();


            }

            public void btnst1() {
                while (count < 1)
                    count++;
                st1.setText(s1.getText().toString() + Integer.toString(count));
                st2.setText(Integer.toString(0));

            }

        });
        btnst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnst2();
            }

            public void btnst2() {
                while (count < 1)
                    count++;
                st2.setText(s2.getText().toString() + Integer.toString(count));
                st1.setText(Integer.toString(0));
            }


        });

        if (btnst1.isSelected() || btnst2.isSelected()) {
            btnst1.setText("");

        }


    }

    public void startDB(View view) {
        new Dbvote(this);
    }

    public void voteee() {
        String ss1 = st1.getText().toString();
        String ss2 = st2.getText().toString();
        db1 = new dbvoter(this);
        String res = db1.voted(ss1, ss2);
        Toast.makeText(this, "Congrats you voted", Toast.LENGTH_LONG).show();
    }
}