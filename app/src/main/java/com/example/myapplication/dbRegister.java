package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.text.PrecomputedText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbRegister extends SQLiteOpenHelper {
    private static final String dbName ="register.db";

    public dbRegister(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String qry = "create table register(id integer primary key,activity text,link text)";
    db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS register");
    onCreate(db);
    }
    public  String addRegister(String activity,String link){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("activity",activity);
        cv.put("link",link);
        long res = db.insert("register",null,cv);
         if(res == -1){
             return  "failed";
         }
         else
         {
             return "success";
         }


    }
public Cursor readRegister(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from register";
    Cursor cursor = db.rawQuery(qry,null);
    return cursor;

}
public Boolean deleteRegister(String activity){
    SQLiteDatabase db = this.getWritableDatabase();

    Cursor c = db.rawQuery("select * from register where activity = ? ", new String[]{activity});
    db.delete("register","activity=?",new String[]{activity});
    final int id = c.getColumnIndex("activity");
    if (c.getCount() > 0) {
        long res = db.delete("register", "activity=?", null);
        if (res == -1) {
            return Boolean.parseBoolean("failed");
        } else {
            return Boolean.parseBoolean("success");
        }
    } else {
        return (false);
    }
}
}
