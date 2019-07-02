package com.sxtsoft.medicdatafragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.sxtsoft.medicdatafragment.fragments.FormularioFragment;
import com.sxtsoft.medicdatafragment.fragments.ListadoFragment;
import com.sxtsoft.medicdatafragment.fragments.PerfilFragment;
import com.sxtsoft.medicdatafragment.model.Lectura;
import com.sxtsoft.medicdatafragment.model.LecturaServices;
import com.sxtsoft.medicdatafragment.model.LecturaServicesSQLite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioActivity extends AppCompatActivity implements ComunicaMenu{

    //private LecturaServices lecturaServices;
    Fragment[] fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //lecturaServices = LecturaServicesImpl.getInstance();
        //lecturaServices = new LecturaServicesSQLite(this);
        fragments = new Fragment[3]; //Creamos array de 3 elementos

        //asignamos a Fragment a cada uno de los elementos del array...
        fragments[0] = new FormularioFragment();
        fragments[1] = new ListadoFragment();
        fragments[2] = new PerfilFragment();

        Bundle extras = getIntent().getExtras();

        // Aquí llega la información de boton_pulsado 0, 1 o 2
        //menu(extras.getInt("BOTON_PULSADO"));
        menu(0);
    }

    @Override
    public void menu(int botonPulsado) {


        FragmentManager fragmentManager = getFragmentManager(); // Ojo importarlo bien!

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // nos pide
        // 1. identificador del contenedor...
        // 2. el fragmento que queremos cargar... hay tres posibilidades.

        fragmentTransaction.replace(R.id.destino, fragments[botonPulsado]);
        fragmentTransaction.commit();
    }
}
