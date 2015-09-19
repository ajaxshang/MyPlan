package com.ajax.myplan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ajax on 2015/7/1.
 * 暂时不用
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "myplan.db";
    private static final int VERSION = 1;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE [myplan] (\n" +
                "[pid] INTEGER  NOT NULL PRIMARY KEY,\n" +
                "[details] TEXT  NULL,\n" +
                "[starttime] DATE  NULL,\n" +
                "[endtime] DATE  NULL,\n" +
                "[isactivate] BOOLEAN  NULL,\n" +
                "[isday] BOOLEAN  NULL,\n" +
                "[isweek] BOOLEAN  NULL,\n" +
                "[isexpire] BOOLEAN  NULL\n" +
                ")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = " db.execSQL(\"DROP TABLE IF EXISTS contacts\");  ";
        db.execSQL(sql);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        System.out.println("--onOpen --- >>");
    }
}
