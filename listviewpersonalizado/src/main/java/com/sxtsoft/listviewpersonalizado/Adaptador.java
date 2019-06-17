package com.sxtsoft.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private LayoutInflater inflater = null;

    private Context contexto;
    private String[][] datos;
    private int[] imagenes;

    public Adaptador(Context contexto, String[][] datos, int[] imagenes){
        this.contexto = contexto;
        this.datos = datos;
        this.imagenes = imagenes;

        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.idContinente);
        TextView duracion = (TextView) vista.findViewById(R.id.idDuracion);
        TextView director = (TextView) vista.findViewById(R.id.idNombrePais);
        ImageView imagen = (ImageView) vista.findViewById(R.id.idImagenFlags);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.idRatingBarPel);

        //vamos a colocar datos en los views...

        titulo.setText(datos[i][1]);
        director.setText(datos[i][0]);
        duracion.setText("duración: " + datos[i][2]);
        imagen.setImageResource(imagenes[i]);
        calificacion.setProgress((Integer.valueOf(datos[i][3])));

        //para cuando hagamos click en el item y veamos la ficha completa

        imagen.setTag(i);

        return vista;


    }

    @Override
    public int getCount() {

        return imagenes.length;
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