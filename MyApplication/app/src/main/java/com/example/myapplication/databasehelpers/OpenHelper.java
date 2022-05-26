package com.example.myapplication.databasehelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.entity.Inventory;
import com.example.myapplication.entity.PriceReset;
import com.example.myapplication.entity.PriceUpdate;

import java.util.Date;

public class OpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Resources.db";
    public static final int DATABASE_VERSION = 1;


    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryInventory = "CREATE TABLE " + Inventory.TABLE_NAME + " (" + Inventory.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Inventory.COLUMN_RESOURCE + " VARCHAR(64), " + Inventory.COLUMN_NUMB + " INTEGER);";
        db.execSQL(queryInventory);
        String queryPriceReset = "CREATE TABLE " + PriceReset.TABLE_NAME + " (" + PriceReset.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PriceReset.COLUMN_DATE + " DATETIME);";
        db.execSQL(queryPriceReset);
        String queryPriceUpdate = "CREATE TABLE " + PriceUpdate.TABLE_NAME + " (" + PriceUpdate.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PriceUpdate.COLUMN_DATE + " DATETIME);";
        db.execSQL(queryPriceUpdate);
        //Inventory
        ContentValues contentValuesInventory = new ContentValues();
        contentValuesInventory.put(Inventory.COLUMN_RESOURCE, "Dirt");
        contentValuesInventory.put(Inventory.COLUMN_NUMB, 0);
        db.insert(Inventory.TABLE_NAME, null, contentValuesInventory);
        contentValuesInventory.put(Inventory.COLUMN_RESOURCE, "Stone");
        contentValuesInventory.put(Inventory.COLUMN_NUMB, 0);
        db.insert(Inventory.TABLE_NAME, null, contentValuesInventory);
        contentValuesInventory.put(Inventory.COLUMN_RESOURCE, "Iron");
        contentValuesInventory.put(Inventory.COLUMN_NUMB, 0);
        db.insert(Inventory.TABLE_NAME, null, contentValuesInventory);
        contentValuesInventory.put(Inventory.COLUMN_RESOURCE, "Copper");
        contentValuesInventory.put(Inventory.COLUMN_NUMB, 0);
        db.insert(Inventory.TABLE_NAME, null, contentValuesInventory);
        //PriceReset
        Date datePres = new Date(System.currentTimeMillis());
        datePres.setHours(datePres.getHours() - 10);
        ContentValues contentValuesPriceReset = new ContentValues();
        contentValuesPriceReset.put(PriceReset.COLUMN_DATE, datePres.getTime());
        db.insert(PriceReset.TABLE_NAME, null, contentValuesPriceReset);
        //PriceUpdate
        ContentValues contentValuesPriceUpdate = new ContentValues();
        contentValuesPriceUpdate.put(PriceUpdate.COLUMN_DATE, datePres.getTime());
        db.insert(PriceUpdate.TABLE_NAME, null, contentValuesPriceUpdate);

//        Resources[0] = "Dirt";
//        Resources[1] = "Stone";
//        Resources[2] = "Iron";
//        Resources[3] = "Copper";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Inventory.TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + PriceReset.TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + PriceUpdate.TABLE_NAME);
        onCreate(db);
    }
}
