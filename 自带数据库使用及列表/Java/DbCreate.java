package com.example.administrator.dc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 数据库创建
 */

public class DbCreate extends SQLiteOpenHelper {

    private String Create_table="CREATE TABLE attrinfo(id Integer PRIMARY KEY asc AUTOINCREMENT,name varchar(50),lon double,lat double,type varchar(20))";

    public DbCreate(Context context) {
        super(context,"Attractions information",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         sqLiteDatabase.execSQL(Create_table);
         Log.e("create success","success");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
