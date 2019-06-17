package com.sxtsoft.medicdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sxtsoft.medicdata.model.Lectura;
import com.sxtsoft.medicdata.model.LecturaServicesImpl;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;
    private Context contexto;

    public Adaptador (Context contexto){
        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        lecturas = LecturaServicesImpl.getInstance().getAll();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.lectura_row, null);

        //recoger todas las vista de ese layout...

        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSiastolica);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);

        Lectura lectura = lecturas.get(position); //ex i

        diastolica.setText(String.valueOf(lectura.getDiastolica()) + "mmHg");
        sistolica.setText(String.valueOf(lectura.getSistolica()) + "mmHg");
        fecha.setText(String.valueOf(lectura.getFechaHora()));

        return vista;
    }


    @Override
    public int getCount() {
        return lecturas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
