package com.sxtsoft.medicdatafragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sxtsoft.medicdatafragment.fragments.FormularioFragment;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Necesario para que la actividad aparezca con un fragment
        // siempre por defecto.
        // Considero que el menú para introducir la lectura debe aparecer
        // siempre primero...
        FormularioFragment formularioFragment = new FormularioFragment();
/*
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(R.id.destino, formularioFragment);

            fragmentTransaction.commit();
        }
*/
    }
}