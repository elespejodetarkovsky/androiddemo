package com.sxtsoft.medicdatafragment.fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sxtsoft.medicdatafragment.R;

import com.sxtsoft.medicdatafragment.adapters.LecturasAdaptador;

public class ListadoFragment extends Fragment {

    ListView lista;

    public ListadoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listadofragment, container, false);

        lista = (ListView) view.findViewById(R.id.idLista);
        lista.setAdapter(new LecturasAdaptador(getActivity()));

        return view;
    }

}
