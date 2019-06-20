package com.sxtsoft.gestionmultas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sxtsoft.gestionmultas.model.Agente;
import com.sxtsoft.gestionmultas.services.impl.AgenteServicesImpl;
import com.sxtsoft.gestionmultas.services.impl.MultaServicesImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FormularioMulta extends AppCompatActivity {

    private Spinner desplegableAgentes;
    private List<Agente> agentes;
    private List<Long> codigosAgentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_multa);

        desplegableAgentes = (Spinner) findViewById(R.id.idfrmAgente);
        agentes = AgenteServicesImpl.getInstance().getAll();

        codigosAgentes = new ArrayList<>(); //Instancio la lista que creará la lista de codigos de Agentes

        for(Agente agente: agentes){
            codigosAgentes.add(agente.getCodigo());
        }
        //adapter para el desplegable de agentes
        ArrayAdapter adapterAgentes = new ArrayAdapter<Long>(this,
                android.R.layout.simple_spinner_dropdown_item, codigosAgentes);

        desplegableAgentes.setAdapter(adapterAgentes);


    }
}
