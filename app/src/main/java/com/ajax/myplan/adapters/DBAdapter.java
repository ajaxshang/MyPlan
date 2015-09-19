package com.ajax.myplan.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ajax.myplan.Base.PlanClass;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ajax on 2015/7/1.
 */
public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_DETAILS = "details";
    static final String KEY_START = "starttime";
    static final String KEY_END = "endtime";
    static final String KEY_ISACTIVATE = "isactivate";
    static final String KEY_ISDAY = "isday";
    static final String KEY_ISWEEK = "isweek";
    static final String KEY_ISEXPIRE = "isexpire";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "myplan.db";
    static final String DATABASE_TABLE = "plan";
    static final int DATABASE_VERSION = 2;

    static final String DATABASE_CREATE =
            "create table plan( _id integer primary key autoincrement, " +
                    "details text not null, starttime text not null,endtime text not null," +
                    "isactivate boolean ,isday boolean,isweek boolean,isexpire boolean);";
    static Context context;

    DatabaseHelper DBHelper;
    static SQLiteDatabase db;

    public DBAdapter() {
    }

    private DBAdapter(Context cxt) {
        this.context = cxt;
        DBHelper = new DatabaseHelper(context);
    }

    public static DBAdapter instance = null;

    public synchronized static DBAdapter getInstance(Context context) {
        if (instance == null) {
            instance = new DBAdapter(context);
        }
        return instance;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            Log.wtf(TAG, "Upgrading database from version " + oldVersion + "to " +
                    newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS plan");
            onCreate(db);
        }
    }

    //open the database
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //close the database
    public void close() {
        DBHelper.close();
    }

    //insert a contact into the database
//    public long insertContact(String name, String email) {
//        ContentValues initialValues = new ContentValues();
//        initialValues.put(KEY_NAME, name);
//        initialValues.put(KEY_EMAIL, email);
//        return db.insert(DATABASE_TABLE, null, initialValues);
//    }

    public long insertPlan(PlanClass planClass) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_DETAILS, planClass.getDetails());
        initialValues.put(KEY_START, planClass.getStarttime());
        initialValues.put(KEY_END, planClass.getEndtime());
        initialValues.put(KEY_ISACTIVATE, planClass.isactivate());
        System.out.println("insert plan :" + planClass.isactivate());
        initialValues.put(KEY_ISDAY, planClass.isday());
        initialValues.put(KEY_ISWEEK, planClass.isweek());
        initialValues.put(KEY_ISEXPIRE, planClass.isexpire());
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //delete a particular contact
    public boolean deletePlan(long rowId) {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    List<PlanClass> list = new ArrayList<PlanClass>();
    String plan[] = new String[]{KEY_ROWID, KEY_DETAILS, KEY_START, KEY_END,
            KEY_ISACTIVATE, KEY_ISDAY, KEY_ISWEEK, KEY_ISEXPIRE};

    //retreves all the contacts
    public synchronized Cursor getAllPlans() {
//        Cursor cursor = db.query(DATABASE_TABLE, plan, null, null, null, null, KEY_ROWID + " DESC ");
//        order by _id desc
        Cursor cursor = db.rawQuery("select * from plan order by _id desc ", null);
        return cursor;
    }

    //获取当日激活的计划
    public synchronized Cursor getTodayPlan() {
        Cursor cursor = db.rawQuery("select * from plan where isactivate = 1", null);
        return cursor;
    }

    //retreves a particular contact
    public Cursor getOnePlan(long rowId) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, plan, KEY_ROWID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null)
            mCursor.moveToFirst();
        return mCursor;
    }

    //updates a contact
    public boolean updatePlan(PlanClass planClass) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_DETAILS, planClass.getDetails());
        initialValues.put(KEY_START, planClass.getStarttime());
        initialValues.put(KEY_END, planClass.getEndtime());
        initialValues.put(KEY_ISACTIVATE, planClass.isactivate());
        initialValues.put(KEY_ISDAY, planClass.isday());
        initialValues.put(KEY_ISWEEK, planClass.isweek());
        initialValues.put(KEY_ISEXPIRE, planClass.isexpire());
        return db.update(DATABASE_TABLE, initialValues, KEY_ROWID + "=" + planClass.getRowID(), null) > 0;
    }


}
