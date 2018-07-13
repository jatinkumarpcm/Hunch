package com.example.jatin.hunch;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static String DataBase_name="School.db";
    public static String Table_name="Student";

    public DataBaseHelper(Context context) {
        super(context, DataBase_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+Table_name+"( Username String)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }
      public long Isinserted(String Username)
      {
          SQLiteDatabase db=  this.getReadableDatabase();
          ContentValues cv = new ContentValues();
          cv.put("Username",Username);
          long result = db.insert(Table_name,null,cv);
          return result;
      }
}
