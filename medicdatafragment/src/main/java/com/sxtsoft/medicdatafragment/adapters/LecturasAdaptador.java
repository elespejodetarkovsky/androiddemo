package com.sxtsoft.medicdatafragment.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sxtsoft.medicdatafragment.R;
import com.sxtsoft.medicdatafragment.model.Lectura;
import com.sxtsoft.medicdatafragment.model.LecturaServices;
import com.sxtsoft.medicdatafragment.model.LecturaServicesSQLite;

import java.text.SimpleDateFormat;
import java.util.List;

public class LecturasAdaptador extends BaseAdapter {

    private static final SimpleDateFormat SDF_FECHA = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat SDF_HORA = new SimpleDateFormat("HH:mm");

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;
    private Context contexto;

    public LecturasAdaptador(Context contexto){

        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

        LecturaServices lecturaServices = new LecturaServicesSQLite(contexto);
        lecturas = lecturaServices.getAll();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.lectura_row, null);

        TextView peso = (TextView) vista.findViewById(R.id.idPeso);
        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSiastolica);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);
        TextView parteDelDia = (TextView) vista.findViewById(R.id.idParteDelDia);

        Lectura lectura = lecturas.get(position);

        peso.setText(String.valueOf(lectura.getPeso()));
        diastolica.setText(String.valueOf(lectura.getDiastolica()));
        sistolica.setText(String.valueOf(lectura.getSistolica()));

        fecha.setText(SDF_FECHA.format(lectura.getFechaHora()));

        //indago en que parte del día se ha hecho la toma
        Integer intHora = Integer.valueOf(SDF_HORA.format(lectura.getFechaHora()));

        if (intHora > 12){
            parteDelDia.setText("Despues Mediodia");
        }else{
            parteDelDia.setText("Antes Mediodia");
        }

        Log.d("INFO","**Minutos: " + intHora);

        peso.setText((String.valueOf(lectura.getPeso())));

        if (position % 2 == 0){
            vista.setBackgroundColor(Color.BLUE);
        }
        else {
            vista.setBackgroundColor(Color.WHITE);
        }
        return vista;

    }

    @Override
    public int getCount() {
        return lecturas.size();
    }

    @Override
    public Object getItem(int position) {
        return lecturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lecturas.get(position).getCodigo();
    }

}