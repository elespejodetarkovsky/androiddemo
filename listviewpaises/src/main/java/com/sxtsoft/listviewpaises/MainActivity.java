package com.sxtsoft.listviewpaises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listaPaises;


    private String[][] datos = {
            {"America", "Canada"},
            {"America", "Estados Unidos"},
            {"America", "Mexico"},
            {"America", "Nicaragua"},
            {"America", "Venezuela"},
            {"America", "Uruguay"},
            {"America", "Argentina"},
            {"America", "Brasil"},
            {"Africa", "Marruecos"},
            {"Africa", "Argelia"},
            {"Africa", "Guinea"},
            {"Africa", "Egipto"},
            {"Africa", "Uganda"},
            {"Europa", "España"},
            {"Europa", "Francia"},
            {"Europa", "Rusia"},
            {"Europa", "Turquía"},
            {"Asia", "China"},
            {"Asia", "Japón"},
            {"Asia", "Corea"}
    };


    private int[] datosimg = {

            R.drawable.canada,
            R.drawable.estadosunidos,
            R.drawable.mexico,
            R.drawable.nicaragua,
            R.drawable.venezuela,
            R.drawable.uruguay,
            R.drawable.argentina,
            R.drawable.brasil,
            R.drawable.marruecos,
            R.drawable.argelia,
            R.drawable.argelia,
            R.drawable.egipto,
            R.drawable.uganda,
            R.drawable.espania,
            R.drawable.francia,
            R.drawable.rusia,
            R.drawable.turquia,
            R.drawable.china,
            R.drawable.argelia,
            R.drawable.corea
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPaises = (ListView) findViewById(R.id.idMiLista);

        //En esta clase SOLO FALTA UNA LINEA DE CODIGO

        Adaptador adaptador = new Adaptador(this, datos, datosimg);

        listaPaises.setAdapter(adaptador);
    }
}
