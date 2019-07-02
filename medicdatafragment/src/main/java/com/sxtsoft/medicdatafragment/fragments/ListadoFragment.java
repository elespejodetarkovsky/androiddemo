package com.sxtsoft.medicdatafragment.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sxtsoft.medicdatafragment.R;
import com.sxtsoft.medicdatafragment.adapters.Adaptador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


public class ListadoFragment extends Fragment {

    private ListView lista;

    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //obtengo una vista del layaut que contiene mi lista
        View view = inflater.inflate(R.layout.listadofragment, container, false);

        //obtengo ahora la lista que se encuentra dentro
        //de la vista anterior
        lista = (ListView) view.findViewById(R.id.idLista);


        //ahora habrá que setearle
        //un adaptador que no tenemos
        Adaptador adaptador = new Adaptador(getActivity());

        lista.setAdapter(adaptador);

        return view;

    }

}
