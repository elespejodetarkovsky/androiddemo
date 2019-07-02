package com.sxtsoft.medicdatafragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sxtsoft.medicdatafragment.ComunicaMenu;


public class MenuFragment extends Fragment {

    // referencias a los tres botones
    private final int[] BOTONES_MENU = {R.id.boton1,
            R.id.boton2,
            R.id.boton3};

    public MenuFragment() {

    }

    // Explicar exactamente qué es el parámetro Bundle en este contexto...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // se genera la view a partir del xml
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        // Declaro una variable del tipo ImageButton
        // Vamos a iterar todos y cada  uno de los botones y en cada vuelta
        // del for añadiremos un listener al botón de turno.
        // (el "botón de turno" es botonMenu
        ImageButton botonMenu;

        // para cada botón...
        for(int i = 0; i < BOTONES_MENU.length; i++){

            // almacenamos en botonMenu todos y cada unos de los botones...

            botonMenu = (ImageButton) miMenu.findViewById(BOTONES_MENU[i]);

            final int BOTON = i; // Ha de ser una constante porque la vamos
            // a utilizar en un listener...

            // Añadimos un listener a cada uno de los botones...
            botonMenu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // Hemos de detectar en que actividad nos encontramos...
                    Activity actividadActual = getActivity();

                    //Hay que enviar la información al interface ComunicaMenu
                    Log.d("**","pulsamos y enviamos info del boton: " + BOTON);

                    // Hemos de invocar al método .menu(boton) de la actividad actual.
                    // Pero para ello, la actividad la hemos de tratar como ComunicaMenu
                    // Por eso hacemos el casting...

                    ComunicaMenu cm = (ComunicaMenu) actividadActual;
                    cm.menu(BOTON);



                }
            });

        }


        return miMenu;
    }

}