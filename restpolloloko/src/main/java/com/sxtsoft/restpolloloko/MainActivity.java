package com.sxtsoft.restpolloloko;

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
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sxtsoft.restpolloloko.model.Camarero;
import com.sxtsoft.restpolloloko.model.LineaPedido;
import com.sxtsoft.restpolloloko.model.Pedido;
import com.sxtsoft.restpolloloko.model.Producto;
import com.sxtsoft.restpolloloko.model.RetrofitHelper;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonCamareros;
    private Button botonProductos;
    private Button botonPedidos;
    private Button botonCrearCamarero;
    private Button botonCrearProducto;
    private Button botonLineasPedidos;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    //private String content; //pasaré el texto a utilizando un bundle para el DestCamareros


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCamareros = (Button) findViewById(R.id.idbtnCamareros);
        botonProductos = (Button) findViewById(R.id.idbtnProductos);
        botonPedidos = (Button) findViewById(R.id.idbtnPedidos);
        botonCrearCamarero = (Button) findViewById((R.id.btnAltaCamarero));
        botonCrearProducto = (Button) findViewById((R.id.btnAltaProducto));
        botonLineasPedidos = (Button) findViewById(R.id.btnLineasPedidos);


        botonCamareros.setOnClickListener(this);
        botonProductos.setOnClickListener(this);
        botonPedidos.setOnClickListener(this);
        botonCrearProducto.setOnClickListener(this);
        botonCrearCamarero.setOnClickListener(this);
        botonLineasPedidos.setOnClickListener(this);

        jsonPlaceHolderApi = RetrofitHelper.getJsonPlaceHolderApi();


    }
    private void setProducto(){

        //necesito crear un producto para pasarlo
        int c = (int)(Math.random()*1000000);
        String name = "Yerba Mate Pajarito" + c;
        String descripcion = "Yerba mate cooperativa";
        final String CATEGORIA = "REFRESCO";


        Producto producto = new Producto(c,name,3,descripcion,new Date(),false,CATEGORIA);

        Call<Producto> call = jsonPlaceHolderApi.createPost(producto);

        //Call<List<Camarero>> call = jsonPlaceHolderApi.getCamareros();
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {

                if (!response.isSuccessful()){
                    Log.d("**", "Ha habido un problema" + response.code());
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                //Camarero camarero = response.body();

            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Log.d("**","Ha habido un problema "+ t.getMessage());
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

                mostrarCamareros();

                break;

            case "1": //productos

                Log.d("**","pulsamos y enviamos info del boton Productos");

                mostrarProductos();

                break;

            case "2": //pedidos
                Log.d("**","pulsamos y enviamos info del boton Pedidos");
                getPedidos();
                break;

            case "3": //alta camareros
                Log.d("**","pulsamos y enviamos info del boton Alta Camarero");
                //setCamarero();

                Intent intent = new Intent(v.getContext(), CrearCamarero.class);

                //Vamor a instanciar un activity

                startActivity(intent);

                break;

            case "4": //alta productos
                Log.d("**","pulsamos y enviamos info del boton Alta Producto");
                setProducto();

                mostrarProductos();

                break;

            case "5": //devuelve lineas de pedidos
                Log.d("**","pulsamos y enviamos info del boton Lineas de pedidos");
                getLineasPedidos();

                break;
        }
    }

    private void mostrarProductos(){

        //Vamos a instanciar un intent

        Intent intentProductos = new Intent(this, DestProductos.class);

        //Vamor a instanciar un activity

        startActivity(intentProductos);

    }

    private void mostrarCamareros(){

        //Vamos a instanciar un intent

        Intent intent = new Intent(this, DestCamareros.class);

        //Vamor a instanciar un activity

        startActivity(intent);

    }

    private void getLineasPedidos(){
        final Map<String, Integer> estadisticasPedidos = new HashMap<>(); //almacenaré los valores

            Call<List<LineaPedido>> call = jsonPlaceHolderApi.getLineaPedido();

            call.enqueue(new Callback<List<LineaPedido>>() {
                @Override
                public void onResponse(Call<List<LineaPedido>> call, Response<List<LineaPedido>> response) {

                    String categoriaLinea;
                    int cantidad = 0;


                    //voy a agregar las categorias y valores en cero...auqnue no me guste... :(

                    estadisticasPedidos.put("COMIDA",0);
                    estadisticasPedidos.put("REFRESCO",0);
                    estadisticasPedidos.put("CERVEZA",0);
                    estadisticasPedidos.put("CAFE",0);
                    estadisticasPedidos.put("AGUA",0);
                    estadisticasPedidos.put("LICOR",0);


                    if (!response.isSuccessful()){
                        Log.d("**", "Ha habido un problema");
                        //textViewResult.setText("Code: " + response.code());
                        return;
                    }

                    List<LineaPedido> lineaPedidos = response.body();

                    for (LineaPedido linea:lineaPedidos ){
                        String content ="";
                        content += "id producto: " + linea.getProducto().getCodigo() + "\n";
                        content += "categoria: " + linea.getProducto().getCategoria() + "\n";
                        categoriaLinea = linea.getProducto().getCategoria();
                        content += "cantidad: " + linea.getQt() + "\n";
                        content += "precio: " + linea.getPrecio() + "\n";

                        //me fijo si existe la categoría.
//                        if (estadisticasPedidos.get(categoriaLinea)==null){
//                            //la categoria no existe...la agrego
//                            estadisticasPedidos.put(categoriaLinea,0); //inicializo la categoría
//                        } else{
//                            int valorAnterior = estadisticasPedidos.get(estadisticasPedidos);
//                            cantidad =  linea.getQt() + valorAnterior;
//
//                            estadisticasPedidos.put(categoriaLinea, cantidad);
//                        }

                        //calculo la nueva cantidad
                        cantidad = estadisticasPedidos.get(categoriaLinea) + linea.getQt();
                        estadisticasPedidos.put(categoriaLinea, cantidad); //coloco la nueva cantidad...

                        cantidad = 0;

                        //Log.d("**" ,Integer.toString(estadisticasPedidos.get(categoriaLinea)));
                        //textViewResult.append(content);

                    }
                    for (Map.Entry<String,Integer> linea : estadisticasPedidos.entrySet()){
                        Log.d("**", "Key = " + linea.getKey() +
                                ", Value = " + linea.getValue());}


                }

                @Override
                public void onFailure(Call<List<LineaPedido>> call, Throwable t) {
                    Log.d("**","Error no determinado" + t.getMessage());
                }
            });

    }
}

