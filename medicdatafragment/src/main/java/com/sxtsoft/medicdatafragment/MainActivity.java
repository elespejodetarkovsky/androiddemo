package com.sxtsoft.medicdatafragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;

import com.sxtsoft.medicdatafragment.fragments.FormularioFragment;
import com.sxtsoft.medicdatafragment.fragments.ListadoFragment;
import com.sxtsoft.medicdatafragment.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Necesario para que la actividad aparezca con un fragment
        // siempre por defecto.
        // Considero que el menú para introducir la lectura debe aparecer
        // siempre primero...

        FormularioFragment fragment = new FormularioFragment();

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(R.id.destino, fragment);

            fragmentTransaction.commit();
        }

    }

}