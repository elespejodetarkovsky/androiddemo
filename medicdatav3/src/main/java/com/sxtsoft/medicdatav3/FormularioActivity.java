package com.sxtsoft.medicdatav3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sxtsoft.medicdatav3.adapter.AdaptadorLecturas;
import com.sxtsoft.medicdatav3.model.JsonPlaceHolderApi;
import com.sxtsoft.medicdatav3.model.Lectura;
import com.sxtsoft.medicdatav3.model.RetrofitHelper;


import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormularioActivity extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private Button enviar;
    private Button mostrarLecturas;

    //atributos para el gps
    private LocationManager locationManager;
    private String providerName;
    private double longitud;
    private double latitud;
    ///////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //lecturaServices = LecturaServicesImpl.getInstance();
        jsonPlaceHolderApi = RetrofitHelper.getJsonPlaceHolderApi();

        enviar = (Button) findViewById(R.id.btnEnviar);
        mostrarLecturas = (Button) findViewById(R.id.btnBotonMostrar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar(v);
            }
        });

        mostrarLecturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioActivity.this, MainActivity.class);

                //Vamor a instanciar un activity

                startActivity(intent);
            }
        });

    }

    public void enviar(View view){
        //comprobamos

        Log.d("**","ENTRAMOS EN ENVIAR");

        EditText editPeso = (EditText) findViewById(R.id.idEntradaPeso);
        EditText editDiastolica = (EditText) findViewById(R.id.idEntradaDiastolica);
        EditText editSistolica = (EditText) findViewById(R.id.idEntradaSistolica);

        double peso = Double.parseDouble(editPeso.getText().toString());
        double diastolica = Double.parseDouble(editDiastolica.getText().toString());
        double sistolica = Double.parseDouble(editSistolica.getText().toString());

        Lectura lectura = new Lectura(new Date() ,peso,diastolica,sistolica,longitud,latitud);

        //Ahora trato el envio
        Call<Lectura> call = jsonPlaceHolderApi.createPost(lectura);

        //Call<List<Camarero>> call = jsonPlaceHolderApi.getCamareros();
        call.enqueue(new Callback<Lectura>() {
            @Override
            public void onResponse(Call<Lectura> call, Response<Lectura> response) {

                if (!response.isSuccessful()){
                    Log.d("**", "Ha habido un problema" + response.code());
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                //Camarero camarero = response.body();

            }

            @Override
            public void onFailure(Call<Lectura> call, Throwable t) {
                Log.d("**","Ha habido un problema "+ t.getMessage());
            }

        });

    }

    private void getGPS(){

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        providerName = locationManager.getBestProvider(criteria, false);

        if (providerName != null && !providerName.equals("")) {

        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(providerName);

        if (location != null){
            Log.d("**", "Longitud: " + location.getLongitude());
            longitud = location.getLongitude();
            Log.d("**","Latitud: " + location.getLatitude());
            latitud = location.getLatitude();
            Log.d("**","proveedor: " + providerName);

        }else{
            Log.d("**"," No se ha encontrado LocationProvider");
            Log.d("**","proveedor: " + providerName);
        }
    }
}
