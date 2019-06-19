package com.sxtsoft.medicdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.sxtsoft.medicdata.model.Lectura;
import com.sxtsoft.medicdata.model.LecturaServices;
import com.sxtsoft.medicdata.model.LecturaServicesImpl;

import java.util.Date;

public class FormularioActivity extends AppCompatActivity {

    private LecturaServices lecturaServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        lecturaServices = LecturaServicesImpl.getInstance();
    }

    public void enviar(View view){
        //comprobamos

        Log.d("INFO","ENTRAMOS EN ENVIAR");

        EditText editPeso = (EditText) findViewById(R.id.idEntradaPeso);
        EditText editDiastolica = (EditText) findViewById(R.id.idEntradaDiastolica);
        EditText editSistolica = (EditText) findViewById(R.id.idEntradaSistolica);

        double peso = Double.parseDouble(editPeso.getText().toString());
        double diastolica = Double.parseDouble(editDiastolica.getText().toString());
        double sistolica = Double.parseDouble(editSistolica.getText().toString());

        //Vamos a instanciar una lectura...
        Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica);

        //Vamor a persistir (guardarla) la lectura...
        lecturaServices.create(lectura);

        //Vamos a instanciar un intent

        Intent intent = new Intent(this, MainActivity.class);

        //Vamor a instanciar un activity

        startActivity(intent);

    }
}
