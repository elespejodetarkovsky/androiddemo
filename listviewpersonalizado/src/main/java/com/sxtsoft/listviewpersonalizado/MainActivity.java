package com.sxtsoft.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView lista;

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

            R.drawable.tarkovsky1,
            R.drawable.tarkovsky2,
            R.drawable.tarkovsky3,
            R.drawable.tarkovsky4,
            R.drawable.tarkovsky5,
            R.drawable.fanho1,
            R.drawable.fanho2,
            R.drawable.fanho3,
            R.drawable.fanho4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idMiLista);

        //En esta clase SOLO FALTA UNA LINEA DE CODIGO

        Adaptador adaptador = new Adaptador(this, datos, datosimg);

        lista.setAdapter(adaptador);
    }
}
