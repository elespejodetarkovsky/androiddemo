package com.sxtsoft.registros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.lstRegistros);
        //Crear datos

        List<Registro> listaRegistros = new ArrayList<>();

        listaRegistros.add(new Registro("Barcelona", 29));
        listaRegistros.add(new Registro("Madrid", 30));
        listaRegistros.add(new Registro("Pamplona", 12));
        listaRegistros.add(new Registro("Bilbao", 10));
        listaRegistros.add(new Registro("Valencia", 31));

        //instancio el adapter
        ListViewAdapter miAdapter = new ListViewAdapter(this, listaRegistros);


        listView.setAdapter(miAdapter);
    }


//    registros.add(new Registro("Barcelona", 29));



}
