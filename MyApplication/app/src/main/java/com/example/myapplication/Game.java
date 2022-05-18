package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.databasehelpers.OpenHelper;

import java.util.Random;

public class Game extends AppCompatActivity {
    Button BackMA;
    Button NextP;
    Button NextS;
    Button NextI;
    Button NextM;
    Button Dig;

    private static int money = 0;
    private static int progress = 0;

    protected static SQLiteDatabase sqLiteDatabase;
    private OpenHelper openHelper;

    public static TextView Textmoney;
    public static TextView Textprogress;
    public static TextView Textresources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();

        NextM = (Button) findViewById(R.id.NextM);
        NextS = (Button) findViewById(R.id.NextS);
        NextP = (Button) findViewById(R.id.NextP);
        BackMA = (Button) findViewById(R.id.BackMA);
        NextI = (Button) findViewById(R.id.NextI);
        Dig = (Button) findViewById(R.id.Dig);

        Textmoney = (TextView) findViewById(R.id.Textmoney);
        Textprogress = (TextView) findViewById(R.id.progress);
        Textresources = (TextView) findViewById(R.id.Textresources);
        Saved.init(getApplicationContext());
        new Saved().Load_saves();
        new Saved().Load_savesDB();
        Diging();
        Screen();
    }

//КОПАТЬ

    private void Diging() {
        Dig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progress == 0)
                    new Diging().Random();
                progress++;
                Textresources.setText(Diging.Res);
                Textprogress.setText(progress + " из " + Diging.ProgressM);
                Money();
            }
        });
    }

//ВРЕМЕННЫЕ ДЕНЬГИ

    private void Money() {
        if (progress == Diging.ProgressM) {
            int min = 10;
            int max = 50;
            int diff = max - min;
            Random random = new Random();
            int i = random.nextInt(diff + 1);
            i += min;
            money += i;
            Textmoney.setText(money + " ");
            progress = 0;
            SRes();
        }
        new Saved().Save();
        new Saved().SaveDB();
    }
//РЕСУРСЫ

    private void SRes(){
        switch (Diging.Res){
            case ("Dirt"):
                Saved.getInventoryDirt().setNumb(Saved.getInventoryDirt().getNumb() + 1);
                break;
            case ("Stone"):
                Saved.getInventoryStone().setNumb(Saved.getInventoryStone().getNumb() + 1);
                break;
            case ("Iron"):
                Saved.getInventoryIron().setNumb(Saved.getInventoryIron().getNumb() + 1);
                break;
            case ("Copper"):
                Saved.getInventoryCopper().setNumb(Saved.getInventoryCopper().getNumb() + 1);
                break;
        }
    }

//ГЕТЕРЫ

    public static int getMoney() {
        return money;
    }

    public static int getProgres() {
        return progress;
    }

//СЕТЕРЫ

    public static void setMoney(int money) {
        Game.money = money;
    }

    public static void setProgres(int progress) {
        Game.progress = progress;
    }

//МЕЖДУ ЭКРАНАМИ

    private void Screen() {
        NextPl();
        NextS();
        NextI();
        NextM();
        BackMA();

    }

    private void BackMA() {
        BackMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackMA = new Intent(Game.this, MainActivity.class);
                startActivity(BackMA);
                onDestroy();
            }
        });
    }

    private void NextPl() {
        NextP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NextP = new Intent(Game.this, Planets.class);
                startActivity(NextP);
            }
        });
    }

    private void NextS() {
        NextS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NextS = new Intent(Game.this, Shop.class);
                startActivity(NextS);
            }
        });
    }

    private void NextI() {
        NextI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NextI = new Intent(Game.this, InventoryAC.class);
                startActivity(NextI);
            }
        });
    }

    private void NextM() {
        NextM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NextM = new Intent(Game.this, Market.class);
                startActivity(NextM);
            }
        });
    }

//КОНЕЦ

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}