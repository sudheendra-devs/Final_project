package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Clubheads extends AppCompatActivity {
private String[] names= {"Jeetank Naidu","Uma Maheshwari","Sudheendra Neela","Vishnu priya","Vaishnavi Bussa","Raj Gopal","Divya sree","Akhila","Prabhav","Prashant","chaitanya","Sumanth"};
private  int[] images = {R.drawable.jeetank,R.drawable.uma,R.drawable.sudheendra,R.drawable.vishnupriya,R.drawable.vaishnavi,R.drawable.raj,R.drawable.divyasree,R.drawable.akhila,R.drawable.prabhav,R.drawable.prashant,R.drawable.chaitanya,R.drawable.sumanth};
private String[] roles = {"Student Coordinator","Student Coordinator","Public Relations","Public Relations","Technical","Technical","Fine Arts","Fine Arts","Logistics","Logistics","Photography","Photography"};
private String[] info ={"The role of the student coordinator is to manage all the club activities","The role of the student coordinator is to manage all the club activities","Responsible for all the public related activities","Responsible for all the public related activities","Responsible for the technical work and updating of all the events","Responsible for the technical work and updating of all the events","They look after the decoration and the artistic work","They look after the decoration and the artistic work","Responsible for the whole backend work","Responsible for the whole backend work","They are the responsible for the video recording and photographs","They are the responsible for the video recording and photographs"};
ArrayList<clubheadModel> arrayList = new ArrayList<>();
RecyclerView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubheads);
        rec = findViewById(R.id.recCh);
        rec.setLayoutManager(new LinearLayoutManager(this));
        prepareList();
       ChAdapter adapter = new ChAdapter(arrayList);
        rec.setAdapter(adapter);
    }
    public void prepareList(){
        int count = 0;
        for(String name: names )

        {
            clubheadModel clubheadModel = new clubheadModel(images[count],name,roles[count],info[count]);
            arrayList.add(clubheadModel);
            count++;

        }
    }
}