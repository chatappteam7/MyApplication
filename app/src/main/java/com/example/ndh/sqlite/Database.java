package com.example.ndh.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NDH on 9/15/2017.
 */

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Hàm dùng để thực hiện câu truy vấn
    public void QueryData(String sql)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); //quyen để viết
        sqLiteDatabase.execSQL(sql);

    }
    //ham lay du lieu trong table database
    public Cursor GetData(String sql)
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
