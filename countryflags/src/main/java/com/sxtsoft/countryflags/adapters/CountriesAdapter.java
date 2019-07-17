package com.sxtsoft.countryflags.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sxtsoft.countryflags.R;
import com.sxtsoft.countryflags.model.Country;

import org.w3c.dom.Text;

import java.util.List;


public class CountriesAdapter extends BaseAdapter {

    private List<Country> paises;
    private LayoutInflater inflater;

    public CountriesAdapter(List<Country> paises, Context context){
        this.paises = paises;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return paises.size();
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


        View view = inflater.inflate(R.layout.row_country, null);

        TextView pais = (TextView) view.findViewById(R.id.idPais);
        TextView capital = (TextView) view.findViewById(R.id.idCapital);
        TextView nativeName = (TextView) view.findViewById(R.id.idNativeName);
        TextView poblacion = (TextView) view.findViewById(R.id.idPoblacion);
        TextView alphaCode = (TextView) view.findViewById(R.id.idAlphaCode);
        TextView area = (TextView) view.findViewById(R.id.idArea);



        ImageView bandera = (ImageView) view.findViewById(R.id.idBandera);

        Country country = paises.get(position);

        pais.setText(country.getName());
        capital.setText(country.getCapital());
        nativeName.setText(country.getNativeName());
        poblacion.setText(String.valueOf(country.getPopulation()));
        alphaCode.setText(country.getAlpha2Code());
        area.setText(String.valueOf(country.getArea()));

        String imageURL = "https://www.countryflags.io/" + country.getAlpha2Code()
                + "/flat/64.png";

        imageURL = imageURL.toLowerCase();

        Picasso.get().load(imageURL).placeholder(R.drawable.psuc).into(bandera);
        Log.d("**", imageURL);
        return view;
    }
}
