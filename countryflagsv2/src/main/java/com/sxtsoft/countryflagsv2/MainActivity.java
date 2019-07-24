package com.sxtsoft.countryflagsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sxtsoft.countryflagsv2.adapters.CountriesAdapter;
import com.sxtsoft.countryflagsv2.model.Country;
import com.sxtsoft.countryflagsv2.retrofit.ApiRest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);


        //configuracion de retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRest apiRest = retrofit.create(ApiRest.class);

        Call<List<Country>> call = apiRest.getAll();

        //Este objeto call en otros lenguajes sería una promesa (promise)

        call.enqueue(new Callback<List<Country>>() {

            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (!response.isSuccessful()){
                    Log.d("**","codigo de error" + response.code());
                    return;
                }

                //dame los datos
                List<Country> countries = response.body();
                Log.d("**","estoy aquí");
                //ahora toca "copulate data"

                //vamos a instanciar un adapter
                CountriesAdapter countriesAdapter = new CountriesAdapter(countries, MainActivity.this);

                //vamos a asignar el adaptador a nuestro ListView
                listView.setAdapter(countriesAdapter);

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("**","codigo de error" + t.getMessage());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Country country = (Country) listView.getItemAtPosition(position);

                Log.d("**", String.valueOf(listView.getItemAtPosition(position)) );
                Intent visorDetalles = new Intent(view.getContext(), CountryDetail.class);
                visorDetalles.putExtra("ALPHA2CODE", country.getAlpha2Code());

                startActivity(visorDetalles);
            }
        });
    }
}