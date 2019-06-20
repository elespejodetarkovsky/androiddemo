package com.sxtsoft.gestionmultas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.sxtsoft.gestionmultas.model.Multa;
import com.sxtsoft.gestionmultas.services.impl.MultaServicesImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Multa> multas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListadoMultas);
        multas = MultaServicesImpl.getInstance().getAll();

        MultasAdapter multasAdapter = new MultasAdapter(this,multas);

        listView.setAdapter(multasAdapter);
    }
}
