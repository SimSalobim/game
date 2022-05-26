package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.databasehelpers.OpenHelper;
import com.example.myapplication.entity.PriceReset;
import com.example.myapplication.entity.PriceUpdate;

import java.util.Date;

public class Market extends AppCompatActivity {

    Button BackGA;
    Button Sell1;
    Button Sell10;

    private SQLiteDatabase sqLiteDatabase;
    private OpenHelper openHelper;

    private static int uvel = 0;
    private static int ponij = 0;
    // продажи в реал времени
    private static int schetE = 0;
    // продажи с начала сбороса рынка
    private static int schetE2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();

        //sqLiteDatabase.execSQL("DROP TABLE " + OpenHelperPriceUpdate.TABLE_NAME);
        //openHelperPriceUpdate.onCreate(sqLiteDatabase);
        //openHelperPriceReset.onCreate(sqLiteDatabase);

        resetPrice();
        updatePrice();

        Sell1 = (Button) findViewById(R.id.sell1);
        Sell10 = (Button) findViewById(R.id.sell10);

        BackGA = (Button) findViewById(R.id.BackGA);

        new Saved().Load_saves();
        new Saved().Load_savesDB();
        Sells();
        BackGA();

    }

    private void Sells(){
        //if (schetE == )
        Sell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Saved.getInventoryDirt().setNumb( Saved.getInventoryDirt().getNumb() - 1);
                Game.setMoney( Game.getMoney() +  15 + uvel - ponij);
                schetE++;
                new Saved().Save();
                new Saved().SaveDB();
            }
        });
        Sell10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Saved.getInventoryDirt().setNumb( Saved.getInventoryDirt().getNumb() - 10);
                Game.setMoney( Game.getMoney() +  (15 * 10) + uvel - ponij);
                schetE+=10;
                new Saved().Save();
                new Saved().SaveDB();
            }
        });
    }
//ОБНОВЛЕНИЕ РЫНКА

    private void resetPrice(){
        Cursor cursor = sqLiteDatabase.query(PriceReset.TABLE_NAME, null, null, null, null, null, PriceReset.COLUMN_DATE + " DESC", null);
        cursor.moveToFirst();
        PriceReset updatePrice = new PriceReset(cursor.getInt(PriceReset.NUM_COLUMN_ID), new Date(cursor.getLong(PriceReset.NUM_COLUMN_DATE)));
        cursor.close();

        Date dateData = updatePrice.getDate();
        Date datePres = new Date(System.currentTimeMillis());

        //СБРОС РЫНКА КАЖДЫЕ 8 ЧАСОВ
        if ( datePres.getYear() - dateData.getYear() >= 0) {
            if ( datePres.getMonth() - dateData.getMonth() >= 0) {
                if ( datePres.getDay() - dateData.getDay() >= 0) {
                    if (( datePres.getHours() > 8 &&  dateData.getHours() < 8) ||
                            ( datePres.getHours() > 16 &&  dateData.getHours() < 16) ||
                            ( datePres.getHours() < 8 &&  dateData.getHours() > 16) ) {

                             ContentValues contentValues = new ContentValues();
                             contentValues.put(PriceReset.COLUMN_DATE, datePres.getTime());
                             sqLiteDatabase.insert(PriceReset.TABLE_NAME, null, contentValues);
                    }
                }
            }
        }

    }

    private void updatePrice() {
        Cursor cursor = sqLiteDatabase.query(PriceUpdate.TABLE_NAME, null, null, null, null, null, PriceUpdate.COLUMN_DATE + " DESC", null);
        cursor.moveToFirst();
        PriceReset updatePrice = new PriceReset(cursor.getInt(PriceUpdate.NUM_COLUMN_ID), new Date(cursor.getLong(PriceUpdate.NUM_COLUMN_DATE)));
        cursor.close();

        Date dateData = updatePrice.getDate();
        Date datePres = new Date(System.currentTimeMillis());
        //ОБНОВЛЕНИЕ РЫНКА КАЖДЫЙ ЧАС
        if ( datePres.getYear() - dateData.getYear() >= 0) {
            if ( datePres.getMonth() - dateData.getMonth() >= 0) {
                if ( datePres.getDay() - dateData.getDay() >= 0) {
                    if ( datePres.getHours() - dateData.getHours() >= 1){
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(PriceUpdate.COLUMN_DATE, datePres.getTime());
                        sqLiteDatabase.insert(PriceUpdate.TABLE_NAME, null, contentValues);
                    }
                }
            }
        }
    }

//

    public static int getSchetE() {
        return schetE;
    }

    public static void setSchetE(int schetE) {
        Market.schetE = schetE;
    }

//
    private void BackGA() {
        BackGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackGA = new Intent(Market.this, Game.class);
                startActivity(BackGA);
            }
        });
    }

}