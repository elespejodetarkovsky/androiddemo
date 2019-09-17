package com.sxtsoft.micontadorpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sxtsoft.micontadorpassword.adapter.ClaveAdapter;
import com.sxtsoft.micontadorpassword.model.Clave;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listClaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo algunas claves
        List<Clave> claves = new ArrayList<>();

        claves.add(new Clave("112"));
        claves.add(new Clave("113"));
        claves.add(new Clave("114"));
        claves.add(new Clave("115"));
        claves.add(new Clave("116"));
        claves.add(new Clave("117"));
        claves.add(new Clave("118"));

        listClaves = (ListView) findViewById(R.id.lstClaves);

        ClaveAdapter claveAdapter = new ClaveAdapter(this, claves);

        listClaves.setAdapter(claveAdapter);

    }
}
