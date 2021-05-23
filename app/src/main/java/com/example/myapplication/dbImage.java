package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class dbImage extends SQLiteOpenHelper {
    Context context;
    public static  String db = "images.db";
    ByteArrayOutputStream bp;
    private byte[] imageinto;
    public dbImage(Context context) {
        super(context, db, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table images(id integer primary key,info text,image BLOB)";
    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS images");
    onCreate(db);
    }
    public void storeImage(modelclass model){
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap imageStoring = model.getImage();
        bp = new ByteArrayOutputStream();
        imageStoring.compress(Bitmap.CompressFormat.JPEG,100,bp);
        imageinto = bp.toByteArray();
        ContentValues cv = new ContentValues();
        cv.put("info",model.getImagename());
        cv.put("image",imageinto);
        long res = db.insert("images",null,cv);
    if(res != -1){
        Toast.makeText(context,"success",Toast.LENGTH_LONG).show();
        db.close();
    }
    else{
        Toast.makeText(context,"failed",Toast.LENGTH_LONG).show();
    }
    }
    public ArrayList<modelclass> getAllImagesData(){
    SQLiteDatabase db = this.getWritableDatabase();
    ArrayList<modelclass> arrayList =new ArrayList<>();
        Cursor c = db.rawQuery("select * from images",null);
        if(c.getCount() > 0){
        while (c.moveToNext()){
            String name = c.getString(1);
            byte [] image = c.getBlob(1);
            Bitmap objBit = BitmapFactory.decodeByteArray(image,0,image.length);
            arrayList.add(new modelclass(name,objBit));
            return arrayList;
        }
        }
        else{
            Toast.makeText(context,"no data exists",Toast.LENGTH_LONG).show();
            return null;
        }
        return null;
    }
}
