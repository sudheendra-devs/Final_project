package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbvoter extends SQLiteOpenHelper {
    private static final String dbname = "vote1.db";

    public dbvoter(Context context) {

        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry1 = "Create Table vote1(id int primary key,name text,name2 text)";
        db.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS vote1");
    onCreate(db);
    }
    public String voted(String p1, String p2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Cursor c = db.rawQuery("select * from vote1",null);
        cv.put("name",p1);
        cv.put("name2",p2);
        long res = db.insert("vote1",null,cv);
        if(res == -1){
            return "success";
        }
        else
        {
            return "failed";
        }
    }

    public int resultvote(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "vote1","name=? OR name2=?",new String[]{s});
        return numRows;




    }
    public int resultvote2(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "vote1"," name2=?",new String[]{s});
        return numRows;




    }
}
