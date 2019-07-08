package com.sxtsoft.restpolloloko;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sxtsoft.restpolloloko.model.Camarero;

import java.lang.reflect.Type;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearCamarero extends AppCompatActivity {

    JsonPlaceHolderApi jsonPlaceHolderApi;
    private TextView nameCamarero;
    private TextView id;
    private Button crearCamarero;
    private Button mostrarCamareros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_camarero);

        id = (TextView) findViewById(R.id.txtidCrearCamarero);
        nameCamarero = (TextView) findViewById(R.id.txtCrearNombreCamarero);
        crearCamarero = (Button) findViewById(R.id.btnCrearCamarero);
        mostrarCamareros = (Button) findViewById(R.id.btnMostrarCamareros);


        crearCamarero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cuando realizo el click
                //debo llamar a la funcion para guardar el camararo

                setCamarero();
            }
        });

        mostrarCamareros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarCamareros();

            }
        });

        setIdCamarero();

        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                Log.d("** getAsJsonPrimitive:", json.getAsJsonPrimitive().toString());
                long millisecons = json.getAsJsonPrimitive().getAsLong();
                return new Date(millisecons);
            }

        });

        builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                long l = src.getTime();

                return new JsonPrimitive(l);
            }
        });


        Gson gson = builder.create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }

    private int setIdCamarero(){
        int c = (int)(Math.random()*1000000);
        id.setText(Integer.toString(c));
        return c;
    }

    private void setCamarero() {

        String name = nameCamarero.getText().toString();

        Camarero camarero = new Camarero(Integer.parseInt(id.getText().toString()), name);

        Call<Camarero> call = jsonPlaceHolderApi.createPost(camarero);

        //Call<List<Camarero>> call = jsonPlaceHolderApi.getCamareros();
        call.enqueue(new Callback<Camarero>() {
            @Override
            public void onResponse(Call<Camarero> call, Response<Camarero> response) {

                if (!response.isSuccessful()){
                    Log.d("**", "Ha habido un problema");
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                //Camarero camarero = response.body();

            }

            @Override
            public void onFailure(Call<Camarero> call, Throwable t) {
                Log.d("**","Ha habido un problema "+ t.getMessage());
            }

        });

        //cambio el id para el próximo camarero
        setIdCamarero();

    }

    private void mostrarCamareros(){

        //Vamos a instanciar un intent

        Intent intent = new Intent(this, DestCamareros.class);

        //Vamor a instanciar un activity

        startActivity(intent);

    }

}
