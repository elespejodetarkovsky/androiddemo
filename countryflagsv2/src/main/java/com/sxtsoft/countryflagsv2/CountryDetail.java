package com.sxtsoft.countryflagsv2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.sxtsoft.countryflagsv2.adapters.CountriesAdapter;
import com.sxtsoft.countryflagsv2.model.Country;
import com.sxtsoft.countryflagsv2.model.Language;
import com.sxtsoft.countryflagsv2.retrofit.ApiRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryDetail extends AppCompatActivity {

    private Spinner cboLenguas;
    private Spinner cboBorders;
    private TextView txtRegion;
    private TextView txtNameCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        cboBorders = (Spinner) findViewById(R.id.cboBorders);
        cboLenguas = (Spinner) findViewById(R.id.cboLenguas);
        txtRegion = (TextView) findViewById(R.id.txtRegion);
        txtNameCountry = (TextView) findViewById(R.id.txtNameCountry);

        //configuracion de retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRest apiRest = retrofit.create(ApiRest.class);

        Intent intent = getIntent();

        //los datos extras llegan a traves de un Bundle
        Bundle alphaCode = intent.getExtras();

        //sólo si el bundle NO es null...
        Call<Country> call = apiRest.getByAlphaCode(alphaCode.getString("ALPHA2CODE"));

        //llamo a la funcion que pintará
        //la bandera

        colocarBandera(alphaCode.getString("ALPHA2CODE"));

        call.enqueue(new Callback<Country>() {

            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {

                if (!response.isSuccessful()){
                    Log.d("**","codigo de error" + response.code());
                    return;
                }

                //dame los datos
                Country country = response.body();
                Log.d("**","estoy aquí");
                //ahora toca "copulate data"
                txtRegion.setText(country.getRegion());
                txtNameCountry.setText(country.getName());
                //creo un array con las lenguas y las fronteras
                List<Language> lenguas = country.getLenguas();
                List<String> borders = country.getBorders();

                //Log.d("**", lenguas[0]);

                List<String> nombreLengua = new ArrayList<>();

                for (Language lengua: lenguas){
                    nombreLengua.add(lengua.getName());
                }

                cboLenguas.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, nombreLengua));
                cboBorders.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, borders));
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.d("**","codigo de error" + t.getMessage());
            }
        });


    }

    private void colocarBandera(String alpha2Code){
        //colocaré la bandera en funcion de su
        //código

        final ImageView imgFlagDetail = (ImageView) findViewById(R.id.imgFlagDetail);

        String imageURL = "https://www.countryflags.io/" + alpha2Code
                + "/flat/64.png";

        imageURL = imageURL.toLowerCase();

        Picasso.get().load(imageURL).placeholder(R.drawable.psuc).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                /* Hay que crear una copia del bitmap para poder trabajar con el, ya que
                 * el bitmap que carga Picasso por defecto no es mutable o editable*/
                Bitmap img = bitmap.copy(Bitmap.Config.ARGB_8888, true);

                //Set it in the ImageView
                imgFlagDetail.setImageBitmap(CropBitmapTransparency(img));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

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
