package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shop extends AppCompatActivity {
    Button Item1;
    Button Item2;
    Button Item3;
    TextView Textmoney;
    Button BackGAfS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Textmoney = (TextView) findViewById(R.id.Textmoney);
        Textmoney.setText(Game.getMoney() + "");
        BackGAfS = (Button)findViewById(R.id.BackGAfS);
        Item1 = (Button) findViewById(R.id.Item1);
        Item2 = (Button) findViewById(R.id.Item2);
        Item3= (Button) findViewById(R.id.Item3);

        Shoping();
        BackGAfS();
    }
    void Shoping() {
        Item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Game.getMoney() >= 10) {
                    Game.setMoney(Game.getMoney() - 10);
                }
                Textmoney.setText(Game.getMoney() + "");
                new Saved().Save();
            }
        });
        Item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Game.getMoney() >= 300) {
                    Game.setMoney(Game.getMoney() - 300);
                }
                Textmoney.setText(Game.getMoney() + "");
                new Saved().Save();
            }
        });
        Item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Game.getMoney() >= 1000) {
                    Game.setMoney(Game.getMoney() - 1000);
                }
                Textmoney.setText(Game.getMoney() + "");
                new Saved().Save();
            }
        });
    }
    void BackGAfS() {
        BackGAfS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shop.this, Game.class);
                startActivity(intent);
            }
        });
    }
}