package com.example.myapplication;

import static com.example.myapplication.Game.Textprogress;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Diging extends AppCompatActivity {

    public Diging(){}

    static public String Resources[] = new String[4];
    static public int DurabilityR[] = new int[4];
    static public String Res;
    static public int Resource;
    static public int ProgressM;
    int i;
    // РАНДОМ
    void Random() {
        Random random = new Random();
        int min = 1;
        int max = 100;
        int diff = max - min;
        i = random.nextInt(diff + 1);
        Switch();
        Randomizer();
        Res = Resources[Resource];
        ProgressM = DurabilityR[Resource];

    }

// Вероятность ресурсов
    void Randomizer(){
        if(i >= 1 && i <50)
        {
            Resource = 0;
        }
        else if (i>=50 && i < 75)
        {
            Resource = 1;
        }
        else if (i>=75 && i < 90)
        {
            Resource = 2;
        }
        else if (i>= 90 && i <= 100)
        {
            Resource = 3;
        }
    }

    // ПЕРЕКЛЮЧЕНИЯ НА РЕСУРСЫ
    void Switch(){
        switch (Planets.PlanetN){
            case 1:
                Earth();
                break;
            case 2:
                SandPlanet();
                break;
        }
    }
    // ПЛАНЕТЫ
    void Earth(){
        Resources[0] = "Dirt";
        Resources[1] = "Stone";
        Resources[2] = "Iron";
        Resources[3] = "Copper";
        DurabilityR[0] = 3;
        DurabilityR[1] = 4;
        DurabilityR[2] = 5;
        DurabilityR[3] = 5;
    }
    //Песочная планета
    void SandPlanet(){
        Resources[0] = "Sand";
        Resources[1] = "Sandstone";
        Resources[2] = "Silver";
        Resources[3] = "Gold";
        DurabilityR[0] = 3;
        DurabilityR[1] = 4;
        DurabilityR[2] = 5;
        DurabilityR[3] = 6;
    }
}
