package com.sxtsoft.restpolloloko;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sxtsoft.restpolloloko.model.Camarero;
import com.sxtsoft.restpolloloko.model.LineaPedido;
import com.sxtsoft.restpolloloko.model.Pedido;
import com.sxtsoft.restpolloloko.model.Producto;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonCamareros;
    private Button botonProductos;
    private Button botonPedidos;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    //private String content; //pasaré el texto a utilizando un bundle para el DestActivity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCamareros = (Button) findViewById(R.id.idbtnCamareros);
        botonProductos = (Button) findViewById(R.id.idbtnProductos);
        botonPedidos = (Button) findViewById(R.id.idbtnPedidos);


        botonCamareros.setOnClickListener(this);
        botonProductos.setOnClickListener(this);
        botonPedidos.setOnClickListener(this);


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

        Gson gson = builder.create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

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
                    //textViewResult.append(content);



                }

            }

            @Override
            public void onFailure(Call<List<Camarero>> call, Throwable t) {
                Log.d("**", "Eroor no determinado");
            }
        });
    }

    private void getProductos(){
        Call<List<Producto>> call = jsonPlaceHolderApi.getProducto();

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if (!response.isSuccessful()){
                    Log.d("**", "Ha habido un problema");
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Producto> productos = response.body();

                for (Producto producto:productos ){
                    String content ="";
                    content += "codigo: " + producto.getCodigo() + "\n";
                    content += "nombre: " + producto.getNombre() + "\n";
                    content += "precio: " + producto.getPrecio() + "\n";
                    content += "descripcion: " + producto.getDescripcion() + "\n";
                    content += "fecha alta: " + producto.getFechaAlta() + "\n";
                    content += "descatalogado: " + producto.isDescatalogado() + "\n";
                    content += "categoria: " + producto.getCategoria() + "\n\n";


                    Log.d("**" ,content);
                    //textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.d("**","Eroor no determinado");
            }
        });

    }

    private void getPedidos(){

        Call<List<Pedido>> call = jsonPlaceHolderApi.getPedido();

        call.enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {

                if (!response.isSuccessful()){
                    Log.d("**", "Ha habido un problema");
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Pedido> pedidos = response.body();

                for (Pedido pedido:pedidos ){
                    String content ="";
                    content += "id: " + pedido.getId() + "\n";
                    content += "fecha: " + pedido.getFecha() + "\n";
                    content += "mesa: " + pedido.getMesa() + "\n";
                    content += "Cod camarero: " + pedido.getCamarero().getCodigo() + "\n";

                    //List<LineaPedido> lineaPedidos =


                    Log.d("**" ,content);
                    //textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                Log.d("**","Error no determinado" + t.getMessage());
            }
        });

    }

    @Override
    public void onClick(View v) {
        String a = (String) v.getTag();
        Log.d("**",a);

        switch (a){
            case "0": //camareros
                Log.d("**","pulsamos y enviamos info del boton Camareros");


                //Vamos a instanciar un intent

                Intent intent = new Intent(v.getContext(), DestActivity.class);


                //Vamor a instanciar un activity

                startActivity(intent);

                break;

            case "1": //productos

                Log.d("**","pulsamos y enviamos info del boton Productos");
                //                //Vamos a instanciar un intent

                Intent intentProductos = new Intent(v.getContext(), DestProductos.class);

                //Vamor a instanciar un activity

                startActivity(intentProductos);
                break;

            case "2": //pedidos
                Log.d("**","pulsamos y enviamos info del boton Pedidos");
                getPedidos();
                break;

        }
    }
}
