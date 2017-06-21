package com.example.administrator.dc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作
 */

public class DbOperator {

    private DbCreate mDbCreate;

    public DbOperator(Context context) {
        mDbCreate=new DbCreate(context);
    }

    public void insert(SightInfo sightInfo){
        SQLiteDatabase sqLiteDatabase=mDbCreate.getWritableDatabase();
        if(sqLiteDatabase.isOpen()){
            ContentValues values=new ContentValues();
            values.put("name",sightInfo.getSight_name());
            values.put("lon",sightInfo.getLon());
            values.put("lat",sightInfo.getLat());
            values.put("type",sightInfo.getType());
            Long id=sqLiteDatabase.insert("attrinfo",null,values);
            Log.e("数据插入成功", String.valueOf(id));
            sqLiteDatabase.close();
        }
    }

    public List<SightInfo> Query_Type(String type){
        SQLiteDatabase db=mDbCreate.getReadableDatabase();
        if(db.isOpen()) {
            String query_sql="select * from attrinfo where type='"+type+"'";
            Log.e("type",query_sql);
            Cursor cursor = db.rawQuery(query_sql, null);
            if (cursor != null && cursor.getCount() > 0) {
                List<SightInfo> sightInfos = new ArrayList<>();
                while (cursor.moveToNext()) {
                    SightInfo sightInfo = new SightInfo();
                    sightInfo.setSight_name(cursor.getString(1));
                    sightInfo.setLon(cursor.getDouble(2));
                    sightInfo.setLat(cursor.getDouble(3));
                    sightInfos.add(sightInfo);
                }
                db.close();
                return sightInfos;
            }
            db.close();
        }
        return  null;
    }

    public List<SightInfo> Query_All(){
        SQLiteDatabase db=mDbCreate.getReadableDatabase();
        if(db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from attrinfo", null);
            if (cursor != null && cursor.getCount() > 0) {
                List<SightInfo> sightInfos = new ArrayList<>();
                while (cursor.moveToNext()) {
                    SightInfo sightInfo = new SightInfo();
                    sightInfo.setSight_name(cursor.getString(1));
                    sightInfo.setLon(cursor.getDouble(2));
                    sightInfo.setLat(cursor.getDouble(3));
                    sightInfos.add(sightInfo);
                }
                db.close();
                return sightInfos;
            }
            db.close();
        }
        return  null;
    }
}
