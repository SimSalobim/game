package com.example.myapplication.databasehelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class OpenHelperPriceUpdate extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Resources.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "UPDATEPRICE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_DATE = "DATE";
    public static final int NUM_COLUMN_ID = 0;
    public static final int NUM_COLUMN_DATE = 1;

    public OpenHelperPriceUpdate(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //db.execSQL("DROP TABLE " + TABLE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " DATETIME);";
        db.execSQL(query);

        Date datePres = new Date(System.currentTimeMillis());
        datePres.setHours(datePres.getHours() - 10);

        ContentValues contentValues = new ContentValues();
        contentValues.put(OpenHelperPriceReset.COLUMN_DATE, datePres.getTime());
        db.insert(OpenHelperPriceReset.TABLE_NAME, null, contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}