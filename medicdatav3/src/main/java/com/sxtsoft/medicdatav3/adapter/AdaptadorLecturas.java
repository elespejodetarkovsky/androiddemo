package com.sxtsoft.medicdatav3.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sxtsoft.medicdatav3.R;
import com.sxtsoft.medicdatav3.model.JsonPlaceHolderApi;
import com.sxtsoft.medicdatav3.model.Lectura;
import com.sxtsoft.medicdatav3.model.RetrofitHelper;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdaptadorLecturas extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;
    private Context contexto;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    public AdaptadorLecturas(Context contexto, List<Lectura> lecturas){
        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.lecturas = lecturas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.lectura_row, null);

        //recoger todas las vista de ese layout...
        SimpleDateFormat adf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat adf2 = new SimpleDateFormat("HH");


        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSiastolica);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);
        TextView peso = (TextView) vista.findViewById(R.id.idEntradaPeso);
        TextView parteDia = (TextView) vista.findViewById(R.id.idParteDelDia);

        Lectura lectura = lecturas.get(position); //ex i

        diastolica.setText(String.valueOf(lectura.getDiastolica()) + " mmHg");
        sistolica.setText(String.valueOf(lectura.getSistolica()) + " mmHg");
        fecha.setText(String.valueOf(adf.format(lectura.getFechaHora())));

        //indago en que parte del día se ha hecho la toma
        Integer intHora = Integer.valueOf(adf2.format(lectura.getFechaHora()));

        if (intHora > 12){
            parteDia.setText("Despues Mediodia");
        }else{
            parteDia.setText("Antes Mediodia");
        }

        Log.d("INFO","**Minutos: " + intHora);

        peso.setText((String.valueOf(lectura.getPeso())));

        if (position % 2 == 0){
            vista.setBackgroundColor(Color.rgb(226,165,43));
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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
