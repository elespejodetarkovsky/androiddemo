package com.sxtsoft.settingshelloworld;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

   // private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //fragment = new FragmentPrueba();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //desde aquí podemos gestionar y
            //por ejemplo gestionar otra activity
            //pero esta nueva activity no dispondrá del menú

//            FragmentManager fragmentManager = getFragmentManager(); // Ojo importarlo bien!
//
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            // nos pide
//            // 1. identificador del contenedor...
//            // 2. el fragmento que queremos cargar... hay tres posibilidades.
//
//            fragmentTransaction.replace(R.id.destino, fragment);
//            fragmentTransaction.commit();
            return true;
        }

            return super.onOptionsItemSelected(item);

    }
}
