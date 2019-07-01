package com.sxtsoft.fragmenthelloworld;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sxtsoft.fragmenthelloworld.fragments.AFragment;
import com.sxtsoft.fragmenthelloworld.fragments.BFragment;
import com.sxtsoft.fragmenthelloworld.fragments.CFragment;

public class DestActivity extends AppCompatActivity implements ComunicaMenu{

    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);

        fragments = new Fragment[3]; //Creamos array de 3 elementos

        //asignamos a Fragment a cada uno de los elementos del array...
        fragments[0] = new AFragment();
        fragments[1] = new BFragment();
        fragments[2] = new CFragment();

        Bundle extras = getIntent().getExtras();

        // Aquí llega la información de boton_pulsado 0, 1 o 2
        menu(extras.getInt("BOTON_PULSADO"));

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
