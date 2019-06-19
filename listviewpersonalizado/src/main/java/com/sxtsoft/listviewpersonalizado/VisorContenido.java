package com.sxtsoft.listviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisorContenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_contenido);

        TextView detallesDirector = (TextView) findViewById(R.id.idDetallesDirector);
        TextView detallesPelicula = (TextView) findViewById(R.id.idDetallesPelicula);

        //TO DO

        //tendremos que recoger los datos enviados por el Intent
        //y utilizar esos datos para mostrar la imagen que corresponda

        Intent intent = getIntent();

        //los datos extras llegan a traves de un Bundle
        Bundle b = intent.getExtras();

        //sólo si el bundle NO es null...
        if (b != null){
            detallesDirector.setText(b.getString("FIT")); //getInt porque sé que será un número
            detallesPelicula.setText(b.getString("DET"));
        }
    }
    }