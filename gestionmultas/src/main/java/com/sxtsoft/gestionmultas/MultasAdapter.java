package com.sxtsoft.gestionmultas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sxtsoft.gestionmultas.model.Multa;

import java.util.List;
import java.util.zip.Inflater;

public class MultasAdapter extends BaseAdapter {

    private Context contexto;
    private List<Multa> multas;
    private final LayoutInflater inflater;

    public MultasAdapter(Context context, List<Multa> multas){
        this.contexto = context;
        this.multas = multas;

        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View fila =  inflater.inflate(R.layout.multa_row, null);

        TextView codigo = (TextView) fila.findViewById(R.id.idCodigoMulta);
        TextView codigoAgente = (TextView) fila.findViewById(R.id.idCodigoAgente);
        TextView monto = (TextView) fila.findViewById(R.id.idMonto);

        Multa multa = multas.get(position);

        codigo.setText(String.valueOf(multa.getCodigo()));
        codigoAgente.setText(String.valueOf(multa.getAgente().getCodigo()));
        monto.setText(String.valueOf(multa.getImporte()));


        return fila;
    }

    @Override
    public int getCount() {
        return multas.size();
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
