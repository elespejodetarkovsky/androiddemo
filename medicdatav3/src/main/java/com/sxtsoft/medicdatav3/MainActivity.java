package com.sxtsoft.medicdatav3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.sxtsoft.medicdatav3.adapter.AdaptadorLecturas;
import com.sxtsoft.medicdatav3.model.JsonPlaceHolderApi;
import com.sxtsoft.medicdatav3.model.Lectura;
import com.sxtsoft.medicdatav3.model.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    JsonPlaceHolderApi jsonPlaceHolderApi;

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idLista);

        //ahora habrá que setearle
        //un adaptadorLecturas que no tenemos
        jsonPlaceHolderApi = RetrofitHelper.getJsonPlaceHolderApi();
        getAll(this);

        //lista.setAdapter(adaptadorLecturas);
    }

    private void getAll(final Context context){
        //mostrará las lecturas, obtendrá un call
        //y luego le pasará las lecturas al adapter
        Call<List<Lectura>> call = jsonPlaceHolderApi.getAll();

        call.enqueue(new Callback<List<Lectura>>() {
            @Override
            public void onResponse(Call<List<Lectura>> call, Response<List<Lectura>> response) {

                if (!response.isSuccessful()){
                    Log.d("**", "Ha habido un problema");
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Lectura> lecturas = response.body();

                for (Lectura lectura : lecturas) {
                    String content = "";
                    content += "sistolica: " + lectura.getSistolica() + "\n";
                    content += "diastolica: " + lectura.getDiastolica() + "\n";

                    Log.d("**", content);

                }

                //le paso, ahora sip...la lista de lecturas
                AdaptadorLecturas adaptadorLecturas = new AdaptadorLecturas(context, lecturas);

                lista.setAdapter(adaptadorLecturas);

            }


            @Override
            public void onFailure(Call<List<Lectura>> call, Throwable t) {
                Log.d("**","Eroor no determinado");
            }
        });
    }
}
