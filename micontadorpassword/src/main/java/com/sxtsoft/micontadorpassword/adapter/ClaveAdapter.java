package com.sxtsoft.micontadorpassword.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.sxtsoft.micontadorpassword.MiClaveRowView;
import com.sxtsoft.micontadorpassword.R;
import com.sxtsoft.micontadorpassword.model.Clave;

import java.util.List;

public class ClaveAdapter extends BaseAdapter {

    private List<Clave> claves;
    private LayoutInflater inflater;

    public ClaveAdapter(Context context, List<Clave> claves){

        this.claves = claves;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return claves.size();
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

        MiClaveRowView miClaveRowView = (MiClaveRowView) view.findViewById(R.id.miClaveRow);

        Clave clave = claves.get(position);

        miClaveRowView.setClave(clave.getClave());
//        MiDisplayView miDisplayView = (MiDisplayView) view.findViewById(R.id.miDisplayView);
//        Button button = (Button) view.findViewById(R.id.btnTest);
//        TextView textView = (TextView) view.findViewById(R.id.txtView);
//
//        Registro registro = datos.get(position);
//
//        double celsius = registro.getCelsius();
//
//        miDisplayView.setCelsius(registro.getCelsius());
//        miDisplayView.setCity(registro.getCity());

//        textView.setText(("texto" + position));


        return view;
    }

}