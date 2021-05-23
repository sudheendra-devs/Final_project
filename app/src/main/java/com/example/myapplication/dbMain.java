package com.example.myapplication;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class dbMain extends SQLiteOpenHelper {
    public static final String Dbname = "notif.db";

    public dbMain(Context context) {
        super(context, Dbname, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table notif(id integer primary key,heading text primary key,notify text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notif");
        onCreate(db);
    }

    public String addNotif( String p1,String p2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("heading", p1);
        cv.put("notify",p2);

        long res = db.insert("notif", null, cv);
        if (res == -1) {
            return "failed";

        } else {
            return "success";
        }
    }

    public boolean deleteNotif(String p1) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("select * from notif where heading = ? ", new String[]{p1});
        db.delete("notif","heading=?",new String[]{p1});
        final int id = c.getColumnIndex("heading");
        if (c.getCount() > 0) {
            long res = db.delete("notif", "heading=?", null);
            if (res == -1) {
                return Boolean.parseBoolean("failed");
            } else {
                return Boolean.parseBoolean("success");
            }
        } else {
            return (false);
        }
    }
    public Cursor viewNotif(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("select * from notif ",null);
        return c;
    }
}
