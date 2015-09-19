package com.ajax.myplan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ajax on 2015/7/1.
 * ��ʱ����
 */
public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        helper = new DBHelper(context);
    }

}
