package com.example.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;

import static com.example.myapplication.Game.Textresources;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.myapplication.Game.Textmoney;
import static com.example.myapplication.Game.Textprogress;

import com.example.myapplication.databasehelpers.OpenHelper;
import com.example.myapplication.entity.Inventory;

public class Saved extends AppCompatActivity {

    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;

    private static Inventory inventoryDirt;
    private static Inventory inventoryStone;
    private static Inventory inventoryIron;
    private static Inventory inventoryCopper;

    public Saved (){}
    public static void init (Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public void Save(){
        editor.putInt ("money", Game.getMoney());
        editor.putInt ("progress", Game.getProgres());
        editor.putInt ("planet", Planets.PlanetN);
        editor.putInt ("progressM", Diging.ProgressM);
        editor.putInt ("resource", Diging.Resource);
        editor.putString("resourceN", Diging.Res);
        editor.commit();
    }

    public void Load_saves () {
        Planets.PlanetN = preferences.getInt("planet", 1);//Планета
        Game.setMoney(preferences.getInt("money", 0));//Монеты
        //Добыча
        Game.setProgres(preferences.getInt("progress", 0)); //Прогресс добычи
        Diging.ProgressM = preferences.getInt("progressM", 0);//Максимальный прогресс добычи
        Diging.Resource = preferences.getInt("resource", 0);//Номер ресурса в массиве
        Diging.Res = preferences.getString("resourceN", "null");//Добываемый ресурс
        Textmoney.setText(Game.getMoney() + "");
        Textresources.setText(Diging.Res);
        Textprogress.setText(Game.getProgres() + " изи " + Diging.ProgressM);
    }

//ДЛЯ ДБ

//СЧИТЫВАНИЕ

    public void Load_savesDB () {
        inventoryDirt = Fuint("Dirt");
        inventoryStone = Fuint ("Stone");
        inventoryIron = Fuint ("Iron");
        inventoryCopper = Fuint ("Copper");
    }

    private void Savedb(Inventory inventory){
        ContentValues contentValues = new ContentValues();
        contentValues.put(OpenHelper.COLUMN_RESOURCE, inventory.getResource());
        contentValues.put(OpenHelper.COLUMN_NUMB, inventory.getNumb());
        Game.sqLiteDatabase.update(OpenHelper.TABLE_NAME, contentValues, "ID = ?", new String[]{String.valueOf(inventory.getId())});
    }

//ЗАПИСЬ В ДБ

    public void SaveDB(){
        Savedb(inventoryDirt);
        Savedb(inventoryStone);
        Savedb(inventoryIron);
        Savedb(inventoryCopper);
    }

    private Inventory Fuint(String ress) {

        Cursor cursor = Game.sqLiteDatabase.query(OpenHelper.TABLE_NAME, null, OpenHelper.COLUMN_RESOURCE + " = '" + ress + "'", null, null, null, null);
        cursor.moveToFirst();
        Inventory inventory = new Inventory(cursor.getInt(OpenHelper.NUM_COLUMN_ID), cursor.getString(OpenHelper.NUM_COLUMN_RESOURCE), cursor.getInt(OpenHelper.NUM_COLUMN_NUMB));
        cursor.close();

        return inventory;
    }

//СЕТЕРЫ и ГЕТЕРЫ

    public static Inventory getInventoryDirt() {
        return inventoryDirt;
    }

    public static void setInventoryDirt(Inventory inventoryDirt) {
        Saved.inventoryDirt = inventoryDirt;
    }

    public static Inventory getInventoryStone() {
        return inventoryStone;
    }

    public static void setInventoryStone(Inventory inventoryStone) {
        Saved.inventoryStone = inventoryStone;
    }

    public static Inventory getInventoryIron() {
        return inventoryIron;
    }

    public static void setInventoryIron(Inventory inventoryIron) {
        Saved.inventoryIron = inventoryIron;
    }

    public static Inventory getInventoryCopper() {
        return inventoryCopper;
    }

    public static void setInventoryCopper(Inventory inventoryCopper) {
        Saved.inventoryCopper = inventoryCopper;
    }

}
