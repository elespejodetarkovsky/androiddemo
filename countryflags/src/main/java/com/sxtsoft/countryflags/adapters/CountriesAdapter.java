package com.sxtsoft.countryflags.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.sxtsoft.countryflags.R;
import com.sxtsoft.countryflags.model.Country;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;


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



        final ImageView bandera = (ImageView) view.findViewById(R.id.idBandera);

        Country country = paises.get(position);

        pais.setText(country.getName());
        capital.setText(country.getCapital());
        nativeName.setText(country.getNativeName());

        DecimalFormat myFormatter = new DecimalFormat("###,###,###.##", DecimalFormatSymbols.getInstance(Locale.GERMANY));
        poblacion.setText(myFormatter.format(country.getPopulation()));

        alphaCode.setText(country.getAlpha2Code());
        area.setText(String.valueOf(country.getArea()));

        //orientacion del texto en los textviews
        pais.setGravity(Gravity.CENTER);
        capital.setGravity(Gravity.LEFT);
        nativeName.setGravity(Gravity.LEFT);
        poblacion.setGravity(Gravity.LEFT);
        area.setGravity(Gravity.LEFT);

        String imageURL = "https://www.countryflags.io/" + country.getAlpha2Code()
                + "/flat/64.png";

        imageURL = imageURL.toLowerCase();

        Picasso.get().load(imageURL).placeholder(R.drawable.psuc).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                /* Hay que crear una copia del bitmap para poder trabajar con el, ya que
                 * el bitmap que carga Picasso por defecto no es mutable o editable*/
                Bitmap img = bitmap.copy(Bitmap.Config.ARGB_8888, true);

                //Set it in the ImageView
                bandera.setImageBitmap(CropBitmapTransparency(img));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });


        Log.d("**", imageURL);


        if (position % 2 == 0){
            view.setBackgroundColor(Color.rgb(255,230,200));
        }
        else {
            view.setBackgroundColor(Color.rgb(211,234,242));
        }

        return view;
    }

    private Bitmap CropBitmapTransparency(Bitmap sourceBitmap){

        int minX = sourceBitmap.getWidth();
        int minY = sourceBitmap.getHeight();
        int maxX = -1;
        int maxY = -1;
        for(int y = 0; y < sourceBitmap.getHeight(); y++)
        {
            for(int x = 0; x < sourceBitmap.getWidth(); x++)
            {
                int alpha = (sourceBitmap.getPixel(x, y) >> 24) & 255;
                if(alpha > 0)   // pixel is not 100% transparent
                {
                    if(x < minX)
                        minX = x;
                    if(x > maxX)
                        maxX = x;
                    if(y < minY)
                        minY = y;
                    if(y > maxY)
                        maxY = y;
                }
            }
        }
        if((maxX < minX) || (maxY < minY))
            return null; // Bitmap is entirely transparent

        // crop bitmap to non-transparent area and return:
        return Bitmap.createBitmap(sourceBitmap, minX, minY, (maxX - minX) + 1, (maxY - minY) + 1);
    }
}
