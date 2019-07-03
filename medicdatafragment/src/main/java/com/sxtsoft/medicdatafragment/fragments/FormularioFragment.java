package com.sxtsoft.medicdatafragment.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.sxtsoft.medicdatafragment.R;
import com.sxtsoft.medicdatafragment.model.Lectura;
import com.sxtsoft.medicdatafragment.model.LecturaServices;
import com.sxtsoft.medicdatafragment.model.LecturaServicesSQLite;
import java.util.Date;

public class FormularioFragment extends Fragment {

    private EditText editPeso;
    private EditText editDiastolica;
    private EditText editSistolica;

    private LecturaServices lecturaServices;

    public FormularioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.formulariofragment, container, false);
        editPeso = (EditText) view.findViewById(R.id.idPeso);
        editDiastolica = (EditText) view.findViewById(R.id.idEntradaDiastolica);
        editSistolica = (EditText) view.findViewById(R.id.idEntradaSistolica);

        lecturaServices = new LecturaServicesSQLite(getActivity());

        view.findViewById(R.id.idButtonGuardar).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 1.- Instanciamos objeto Lectura

                double peso = Double.parseDouble(editPeso.getText().toString());
                double diastolica = Double.parseDouble(editDiastolica.getText().toString());
                double sistolica = Double.parseDouble(editSistolica.getText().toString());

                Lectura lectura = new Lectura(new Date(),peso,diastolica,sistolica,0,0);

                // 2.- Persistimos objeto Lectura

                lecturaServices.create(lectura);

                // 3.- Substituyo el fragmento actual por el de la lista...

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.destino, new ListadoFragment());
                fragmentTransaction.commit();
            }
        });
        return view;
    }


}
