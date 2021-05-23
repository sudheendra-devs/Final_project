package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbvote extends SQLiteOpenHelper {
    public static final String dbname = "vote.db";
    public Dbvote(Context context){
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String qry = "Create Table vote(sc1 text,sc2 text,p1 text,p2 text,f1 text,f2 text,l1 text,l2 text,t1 text,t2 text)";

    db.execSQL(qry);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS vote");

        onCreate(db);

    }
public String addVote(String s1,String s2,String p1,String p2,String f1,String f2,String l1,String l2,String t1,String t2) {
SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv= new ContentValues();
    Cursor c = db.rawQuery("select * from vote ",null);
    cv.put("sc1",s1);
    cv.put("sc2",s2);
    cv.put("p1",p1);
    cv.put("p2",p2);
    cv.put("f1",f1);
    cv.put("f2",f2);
    cv.put("l1",l1);
    cv.put("l2",l2);
    cv.put("t1",t1);
    cv.put("t2",t2);
    long res = db.insert("vote",null,cv);
    if(res == -1){
        return "true";
    }
    else {
        return "false";

    }
}


        public boolean deletevote(String s1){
            SQLiteDatabase db2 = this.getWritableDatabase();
            Cursor c = db2.rawQuery("select * from vote  where sc1 = ? ",new String[]{s1});
            long res = db2.delete("vote","sc1=?",new String[]{s1} );
            if(res == -1){
                return Boolean.parseBoolean("failed");
            }
            else{
                return Boolean.parseBoolean("success");
            }
        }

public Cursor sc1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select sc1,sc2 from vote ",null);
        return c;
    }
    public Cursor p1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select p1,p2 from vote ",null);
        return c;
    }
    public Cursor f1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select f1,f2 from vote ",null);
        return c;
    }
    public Cursor l1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select l1,l2 from vote ",null);
        return c;
    }
    public Cursor t1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select t1,t2 from vote ",null);
        return c;
    }


}
