package com.sxtsoft.restpolloloko;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
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

public class DestProductos extends AppCompatActivity {
    private TextView textViewProductos;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest_productos);

        textViewProductos = (TextView) findViewById(R.id.text_view_result_Productos);

        jsonPlaceHolderApi = RetrofitHelper.getJsonPlaceHolderApi();

        getProductos();
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
                    textViewProductos.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.d("**","Eroor no determinado");
            }
        });

    }

}
