package com.sxtsoft.gestionmultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sxtsoft.gestionmultas.model.Agente;
import com.sxtsoft.gestionmultas.model.Tipo;
import com.sxtsoft.gestionmultas.services.impl.AgenteServicesImpl;
import com.sxtsoft.gestionmultas.services.impl.MultaServicesImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FormularioMulta extends AppCompatActivity {

    private Spinner desplegableAgentes;
    private Spinner desplegableTipo;
    private List<Agente> agentes;
    private List<Long> codigosAgentes;
    private TextView motivo;
    private TextView observaciones;
    private RadioGroup aceptada;
    private Agente agente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_multa);

        //definicion de los objetos del formulario
        desplegableAgentes = (Spinner) findViewById(R.id.idfrmAgente);
        desplegableTipo = (Spinner) findViewById(R.id.idfrmTipo);
        aceptada = (RadioGroup) findViewById(R.id.idfrmAceptada);




        //obtengo la única instancia de la implementacion del manejo de Agentes.
        agentes = AgenteServicesImpl.getInstance().getAll();
        motivo = (TextView) findViewById(R.id.idfrmMotivo);
        observaciones = (TextView) findViewById(R.id.idfrmObs);

        codigosAgentes = new ArrayList<>(); //Instancio la lista que creará la lista de codigos de Agentes

        for(Agente agente: agentes){
            codigosAgentes.add(agente.getCodigo());
        }

            //adapter para el desplegable de agentes
            ArrayAdapter adapterAgentes = new ArrayAdapter<Long>(this,
                    android.R.layout.simple_spinner_dropdown_item, codigosAgentes);

            desplegableAgentes.setAdapter(adapterAgentes);

            //Adapter para el desplegable de Tipos
            ArrayAdapter adapterTipo = new ArrayAdapter<Tipo>(this,
                    android.R.layout.simple_spinner_dropdown_item, Tipo.values());

            desplegableTipo.setAdapter(adapterTipo);


    }

    public void enviar(View view){
        //comprobamos

        Log.d("INFO","ENTRAMOS EN ENVIAR");


        //primero debo identificar el Agente para enviarlo
        agente = AgenteServicesImpl.getInstance().read((long)desplegableAgentes.getSelectedItem());



        String strMotivo = motivo.getText().toString();
        String strObs = observaciones.getText().toString();

        double peso = Double.parseDouble(editPeso.getText().toString());
        double diastolica = Double.parseDouble(editDiastolica.getText().toString());
        double sistolica = Double.parseDouble(editSistolica.getText().toString());

        //Vamos a instanciar una lectura...
        Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica);

        //Vamor a persistir (guardarla) la lectura...
        lecturaServices.create(lectura);

        //Vamos a instanciar un intent

        Intent intent = new Intent(this, MainActivity.class);

        //Vamor a instanciar un activity

        startActivity(intent);

    }
}
