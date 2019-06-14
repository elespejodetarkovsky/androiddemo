package com.sxtsoft.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String[][] datos = {
            {"Tarkovsky", "Zerkalo", "200min","8","blabola1"},
            {"Tarkovsky", "Ivan", "200min","9","blabola2"},
            {"Tarkovsky", "Nostalghia", "200min","7","blabola3"},
            {"Tarkovsky", "Stalker", "200min","6","blabola4"},
            {"Tarkovsky", "Andrei Rublev", "200min","8","blabola5"},
            {"Fan ho", "Hong Kong 65", "200min","10","blabola1"},
            {"Fan ho", "Hong Kong 59", "200min","9","blaasbola1"},
            {"Fan ho", "Hong Kong 66", "200min","7","blaasdbola1"},
            {"Fan ho", "China 67", "200min","10","aadadvvvdf"}
    };

    private int[] datosimg = {

            R.drawable.Tarkovsky1,
            R.drawable.Tarkovsky2,
            R.drawable.Tarkovsky3,
            R.drawable.Tarkovsky4,
            R.drawable.Tarkovsky5,
            R.drawable.FanHo1,
            R.drawable.FanHo2,
            R.drawable.FanHo3,
            R.drawable.FanHo4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
