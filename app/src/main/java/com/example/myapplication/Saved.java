package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Saved {
    private static final  String EDIT = "ed1";
    SharedPreferences spef;
    SharedPreferences.Editor  editor;
    Context con;
    int PRIVATE_MODE = 0;
    public Saved(Context context){
        this.con = context;
        final String PREF_NAME = con.getString(R.string.app_name)+ "_pref";
        editor = spef.edit();
    }
    public String getEdit(){
        return spef.getString(EDIT,"");
    }
    public void setEdit(String text){
        editor.putString(EDIT,text);
        editor.commit();
    }


}
