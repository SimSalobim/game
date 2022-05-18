package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class InventoryAC extends AppCompatActivity {

    Button BackGA;
    public  TextView TextDirt;
    public  TextView TextStone;
    public  TextView TextIron;
    public  TextView TextCopper;

    public ListView Resour;
    final String[] res = new String[4];

    public InventoryAC() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        BackGA = (Button)findViewById(R.id.BackGAfI);

        ListView Resour = findViewById(R.id.Resour);
        new Saved().Load_savesDB();
        Inden();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android. R.layout.simple_list_item_1, res);
        Resour.setAdapter(adapter);


        BackGAfI();
    }

    private void Inden(){
        res[0] = "Dirt" + " " +Saved.getInventoryDirt().getNumb();
        res[1] = "Stone" + " " + Saved.getInventoryStone().getNumb();
        res[2] = "Iron" + " " + Saved.getInventoryIron().getNumb();
        res[3] = "Copper" + " " + Saved.getInventoryCopper().getNumb();
    }

    private void BackGAfI() {
        BackGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InventoryAC.this, Game.class);
                startActivity(intent);
            }
        });
    }

}