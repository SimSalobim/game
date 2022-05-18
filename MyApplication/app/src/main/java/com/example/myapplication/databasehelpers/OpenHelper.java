package com.example.myapplication.databasehelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Resources.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "INVENTORYS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_RESOURCE = "RESOURCE";
    public static final String COLUMN_NUMB = "NUMB";
    public static final int NUM_COLUMN_ID = 0;
    public static final int NUM_COLUMN_RESOURCE = 1;
    public static final int NUM_COLUMN_NUMB = 2;

    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RESOURCE + " VARCHAR(64), " + COLUMN_NUMB + " INTEGER);";
        db.execSQL(query);

        ContentValues contentValues = new ContentValues();
        contentValues.put(OpenHelper.COLUMN_RESOURCE, "Dirt");
        contentValues.put(OpenHelper.COLUMN_NUMB, 0);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.put(OpenHelper.COLUMN_RESOURCE, "Stone");
        contentValues.put(OpenHelper.COLUMN_NUMB, 0);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.put(OpenHelper.COLUMN_RESOURCE, "Iron");
        contentValues.put(OpenHelper.COLUMN_NUMB, 0);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.put(OpenHelper.COLUMN_RESOURCE, "Copper");
        contentValues.put(OpenHelper.COLUMN_NUMB, 0);
        db.insert(TABLE_NAME, null, contentValues);

//        Resources[0] = "Dirt";
//        Resources[1] = "Stone";
//        Resources[2] = "Iron";
//        Resources[3] = "Copper";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
