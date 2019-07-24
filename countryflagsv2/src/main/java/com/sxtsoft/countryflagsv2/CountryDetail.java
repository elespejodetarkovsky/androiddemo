package com.sxtsoft.countryflagsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.sxtsoft.countryflagsv2.adapters.CountriesAdapter;
import com.sxtsoft.countryflagsv2.model.Country;
import com.sxtsoft.countryflagsv2.retrofit.ApiRest;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        cboBorders = (Spinner) findViewById(R.id.cboBorders);
        cboLenguas = (Spinner) findViewById(R.id.cboLenguas);
        txtRegion = (TextView) findViewById(R.id.txtRegion);

        //configuracion de retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRest apiRest = retrofit.create(ApiRest.class);

        Intent intent = getIntent();

        //los datos extras llegan a traves de un Bundle
        Bundle b = intent.getExtras();

        //sólo si el bundle NO es null...
        Call<Country> call = apiRest.getByAlphaCode(b.getString("ALPHA2CODE"));

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

                //creo un array con las lenguas y las fronteras
                String[] lenguas = country.getLenguas();
                String[] borders = country.getBorders();

                Log.d("**", lenguas[0]);
                //cboBorders.setAdapter(new ArrayAdapter<String>(this, this, android.R.layout.simple_spinner_item, lenguas));
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.d("**","codigo de error" + t.getMessage());
            }
        });
    }
}
