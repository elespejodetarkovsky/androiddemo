package com.sxtsoft.registros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<Registro> datos;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context, List<Registro> datos){

        this.datos = datos;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.row_layout, null);

        MiDisplayView miDisplayView = (MiDisplayView) view.findViewById(R.id.miDisplayView);
        Button button = (Button) view.findViewById(R.id.btnTest);
        TextView textView = (TextView) view.findViewById(R.id.txtView);

        Registro registro = datos.get(position);

        double celsius = registro.getCelsius();

        miDisplayView.setCelsius(registro.getCelsius());
        miDisplayView.setCity(registro.getCity());

        textView.setText(("texto" + position));


        return view;
    }

}
