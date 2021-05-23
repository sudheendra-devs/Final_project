package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DbHelper extends SQLiteOpenHelper {
    public static final String dbname = "event.db";


    public DbHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table event(id integer primary key ,headname text,name text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS event");
        onCreate(db);


    }

    public String addRecord(String p1,String p2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Cursor c = db.rawQuery("select * from event",null);

        cv.put("name", p2);
    cv.put("headname",p1);
        long res = db.insert("event", null, cv);
        if (res == -1) {
            return "failed";
        } else {
            return "success";
        }
    }

    public boolean deleteRecord(String p1) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("select * from event where headname = ? ", new String[]{p1});
        db.delete("event","headname=?",new String[]{p1});
        final int id = c.getColumnIndex("headname");
        if(c.moveToFirst()){
            do{
                int id1 = c.getColumnIndex("id");
            }while (c.moveToNext());
        }

        if (c.getCount() > 0) {
            long res = db.delete("event", "headname=?", null);
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

        Cursor c = db.rawQuery("select * from event ",null);
        return c;
    }
}