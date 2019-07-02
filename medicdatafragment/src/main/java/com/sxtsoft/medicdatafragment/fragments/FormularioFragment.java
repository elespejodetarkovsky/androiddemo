package com.sxtsoft.medicdatafragment.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxtsoft.medicdatafragment.R;
import com.sxtsoft.medicdatafragment.model.LecturaServices;
import com.sxtsoft.medicdatafragment.model.LecturaServicesSQLite;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment {

    private LecturaServices lecturaServices;

    public FormularioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        lecturaServices = new LecturaServicesSQLite(getActivity());
        return inflater.inflate(R.layout.formulariofragment, container, false);
    }

}
