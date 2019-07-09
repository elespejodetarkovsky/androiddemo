package com.sxtsoft.restpolloloko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sxtsoft.restpolloloko.model.Camarero;
import com.sxtsoft.restpolloloko.model.Producto;
import com.sxtsoft.restpolloloko.model.RetrofitHelper;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DestCamareros extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);

        textViewResult = (TextView) findViewById(R.id.text_view_result);


        jsonPlaceHolderApi = RetrofitHelper.getJsonPlaceHolderApi();

        getCamareros();
    }

    private void getCamareros() {

        Call<List<Camarero>> call = jsonPlaceHolderApi.getCamareros();

        call.enqueue(new Callback<List<Camarero>>() {
            @Override
            public void onResponse(Call<List<Camarero>> call, Response<List<Camarero>> response) {

                if (!response.isSuccessful()) {
                    Log.d("**", "Ha habido un problema");
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Camarero> camareros = response.body();

                for (Camarero camarero : camareros) {
                    String content = "";
                    content = "prueba";
                    content += "codigo: " + camarero.getCodigo() + "\n";
                    content += "nombre: " + camarero.getNombre() + "\n";

                    Log.d("**", content);
                    textViewResult.append(content);



                }

            }

            @Override
            public void onFailure(Call<List<Camarero>> call, Throwable t) {
                Log.d("**", "Eroor no determinado");
            }
        });
    }


}
