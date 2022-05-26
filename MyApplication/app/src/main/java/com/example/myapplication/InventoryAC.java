package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.entity.InventList;
import com.example.myapplication.entity.InventListAdapter;

public class InventoryAC extends AppCompatActivity {

    Button BackGA;
    public  TextView TextDirt;
    public  TextView TextStone;
    public  TextView TextIron;
    public  TextView TextCopper;

    public ListView listView;
    final String[] res = new String[4];

    public InventoryAC() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        new Saved().Load_savesDB();

        InventListAdapter dialogAdapter = new InventListAdapter(this, createDialogs());
        ListView listView = findViewById(R.id.ListView);
        listView.setAdapter(dialogAdapter);

        BackGA = (Button)findViewById(R.id.BackGAfI);
        BackGAfI();
    }

    InventList[] createDialogs(){
        InventList[] dialogs = new InventList[4];
        String[] names = {Saved.getInventoryDirt().getResource() ,Saved.getInventoryStone().getResource() ,Saved.getInventoryIron().getResource(),Saved.getInventoryCopper().getResource()};
        int[] numbs = {Saved.getInventoryDirt().getNumb(),Saved.getInventoryStone().getNumb(),Saved.getInventoryIron().getNumb(),Saved.getInventoryCopper().getNumb()};

        for(int i = 0; i < 5; i++){
            InventList dialog = new InventList();
            dialog.name = names[i];
            dialog.numb = numbs[i];
            dialogs[i] = dialog;
        }
        return dialogs;
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