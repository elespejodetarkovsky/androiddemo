package com.sxtsoft.fragmenthelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int botonPulsado) {

        //Estando donde estamos (MainActivity) lo que toca "si o si" es
        //ir a la actividad DestActivity
        //para ello programaos el "aparato" Intent

        Intent intent = new Intent(this, DestActivity.class);

        //A DestActivity le pasamos información sobre el numero de botón
        //que se ha pulsado, que será 0, 1 o 2.

        intent.putExtra("BOTON_PULSADO", botonPulsado);

        startActivity(intent);

    }
}
