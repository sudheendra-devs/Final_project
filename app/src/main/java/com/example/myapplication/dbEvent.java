package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class dbEvent extends SQLiteOpenHelper {
    public static final String dbname = "event1.db";


    public dbEvent(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table event1(id integer primary key ,headname text,name text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS event1");
        onCreate(db);


    }

    public String addRecord(String p1,String p2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Cursor c = db.rawQuery("select * from event1",null);

        cv.put("name", p2);
        cv.put("headname",p1);
        long res = db.insert("event1", null, cv);
        if (res == -1) {
            return "failed";
        } else {
            return "success";
        }
    }

    public boolean deleteRecord(String p1) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("select * from event1 where headname = ? ", new String[]{p1});
        db.delete("event1","headname=?",new String[]{p1});
        final int id = c.getColumnIndex("headname");
        if (c.getCount() > 0) {
            long res = db.delete("event1", "headname=?", null);
            if (res == -1) {
                return Boolean.parseBoolean("failed");
            } else {
                return Boolean.parseBoolean("success");
            }
        } else {
            return (false);
        }
    }


    public Cursor viewRecord(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("select * from event1 ",null);
        return c;
    }
}