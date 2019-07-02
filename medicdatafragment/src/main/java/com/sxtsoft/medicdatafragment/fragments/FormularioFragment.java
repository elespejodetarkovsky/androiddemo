package com.sxtsoft.medicdatafragment.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sxtsoft.medicdatafragment.R;
import com.sxtsoft.medicdatafragment.model.Lectura;
import com.sxtsoft.medicdatafragment.model.LecturaServices;
import com.sxtsoft.medicdatafragment.model.LecturaServicesSQLite;

import java.util.Date;


public class FormularioFragment extends Fragment {

    private LecturaServices lecturaServices;
    private View view; //será la vista generada del Fragment Formulario

    public FormularioFragment() {
        // Required empty public constructor
        //lecturaServices = new LecturaServicesSQLite(this.getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.formulariofragment, container, false);
        //lecturaServices = new LecturaServicesSQLite(this.getActivity());

        // Añadimos un listener a cada uno de los botones...
        Button button = (Button) view.findViewById(R.id.idButtonGuardar);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Hemos de detectar en que actividad nos encontramos...
                Activity actividadActual = getActivity();

                lecturaServices = new LecturaServicesSQLite(getActivity().getApplicationContext());

                //Hay que enviar la información al interface ComunicaMenu
                Log.d("**","pulsamos y enviamos info del boton: ");


            }
        });

        return view;
    }

//    public void enviar(View view){
//        //comprobamos
//
//        Log.d("INFO","ENTRAMOS EN ENVIAR");
//
//        EditText editPeso = (EditText) findViewById(R.id.idEntradaPeso);
//        EditText editDiastolica = (EditText) findViewById(R.id.idEntradaDiastolica);
//        EditText editSistolica = (EditText) findViewById(R.id.idEntradaSistolica);
//
//        double peso = Double.parseDouble(editPeso.getText().toString());
//        double diastolica = Double.parseDouble(editDiastolica.getText().toString());
//        double sistolica = Double.parseDouble(editSistolica.getText().toString());
//
//        //Vamos a instanciar una lectura...
//        //Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica);
//
//        //Vamor a persistir (guardarla) la lectura...
//        //lecturaServices.create(lectura);
//
//        //guardaré en la base de datos
//        //DateFormat dateFormat = new SimpleDateFormat("hh:mm");
//        //String strDate = dateFormat.format(new Date());
//
//        Lectura lectura = new Lectura(new Date() ,peso,diastolica,sistolica);
//        lecturaServices.create(lectura);
//
//        //Vamos a instanciar un intent
//
//        Intent intent = new Intent(this, MainActivity.class);
//
//        //Vamor a instanciar un activity
//
//        startActivity(intent);
//
//    }
//    public void buscarId(View view){
//        //comprobamos
//
//        Log.d("INFO","ENTRAMOS EN Busqueda Id");
//
//
//        Lectura lectura = lecturaServices.read(4);
//
//        Log.d("INFO", lectura.toString());
//
//        lecturaServices.delete(4);
//
//        //Vamos a instanciar un intent
//
//        //Intent intent = new Intent(this, MainActivity.class);
//
//        //Vamor a instanciar un activity
//
//        //startActivity(intent);
//
//    }

}
