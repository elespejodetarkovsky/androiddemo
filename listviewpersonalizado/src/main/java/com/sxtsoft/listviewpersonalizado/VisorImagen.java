package com.sxtsoft.listviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        ImageView imagen = (ImageView) findViewById(R.id.idImagenGrande);
        //TO DO

        //tendremos que recoger los datos enviados por el Intent
        //y utilizar esos datos para mostrar la imagen que corresponda

        Intent intent = getIntent();

        //los datos extras llegan a traves de un Bundle
        Bundle b = intent.getExtras();

        //sólo si el bundle NO es null...
        if (b != null){
            imagen.setImageResource(b.getInt("IMG")); //getInt porque sé que será un número
        }
    }
}
