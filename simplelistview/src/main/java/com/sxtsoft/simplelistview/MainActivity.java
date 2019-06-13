package com.sxtsoft.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    String[] valores = {"pepe","Carlos","Esteban","Tatiana","Federico","Juan",
            "Manuel","Sebastian","Adelaida","Alfonsia","Veronica","Yulei","Jin","Jordi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.idListView);

        //necesitamos un adaptador
        // pasamos tres parámetros en el constructor

        // 1- el contexto
        // 2- que tipo de grafico
        // 3- El String (los datos) el array

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_expandable_list_item_1, valores);

        listView.setAdapter(adapter);
    }
}
