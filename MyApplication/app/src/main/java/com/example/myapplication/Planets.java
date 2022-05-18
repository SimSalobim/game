package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.databasehelpers.OpenHelper;

public class Planets extends AppCompatActivity {
    private SQLiteDatabase sqLiteDatabase;
    private OpenHelper openHelper;

    Button Earth;
    Button SandPlanet;
    public static TextView Textplanet;

    Button BackGAfP;

    static public int PlanetN = 1;
    static public String Planets[] = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
        BackGAfP = (Button) findViewById(R.id.BackGAfP);
        Earth = (Button) findViewById(R.id.Earth);
        SandPlanet = (Button) findViewById(R.id.SandPlanet);
        Textplanet = (TextView) findViewById(R.id.Textplanet);

        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();
        DB();

        Planets[0] = "Земля";
        Planets[1] = "Песочная планета";

        Textplanet.setText(Planets[PlanetN-1]);
        Planets();
        BackGAfP();
    }

 // ПЛАНЕТЫ
    void Planets(){
        Planets1();
        Planets2();
    }

    void Planets1(){
        Earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlanetN = 1;
                Textplanet.setText(Planets[PlanetN-1]);
                Game.setProgres(Game.getProgres() - Game.getProgres());
                new Saved().Save();
            }
        });
    }

    void Planets2(){
        SandPlanet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlanetN = 2;
                Textplanet.setText(Planets[PlanetN-1]);
                Game.setProgres(Game.getProgres() - Game.getProgres());
                new Saved().Save();
            }
        });
    }

//ДБ

    void DB() {

    }

//



    // ВЫХОД
    void BackGAfP() {
        BackGAfP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Planets.this, Game.class);
                startActivity(intent);
            }
        });
    }
}