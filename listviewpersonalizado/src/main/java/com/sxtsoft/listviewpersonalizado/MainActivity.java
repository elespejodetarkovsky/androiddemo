package com.sxtsoft.listviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView lista;

    private String[][] datos = {
            {"Tarkovsky", "Zerkalo","150min","9","Un hombre, Alekséi, habla con su esposa sobre su situación actual y los motivos por los que se han distanciado. La película es una evocación continua de recuerdos y sentimientos del propio Tarkovsky que viajan en diferentes tiempos"},
            {"Tarkovsky", "Nostalghia","180","8","asda"},
            {"Tarkovsky", "Andrei Rublev","210","9","kajsd"},
            {"Tarkovsky", "Sacrificio","210","9","kajsd"},
            {"Tarkovsky", "Stalker","210","9","kajsd"},
            {"Tarkovsky", "Hong Kong 65", "200min","10","blabola1"},
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

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent visorDetalles = new Intent(view.getContext(), VisorContenido.class);
                visorDetalles.putExtra("FIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);

                startActivity(visorDetalles);
            }
        });
    }
}
