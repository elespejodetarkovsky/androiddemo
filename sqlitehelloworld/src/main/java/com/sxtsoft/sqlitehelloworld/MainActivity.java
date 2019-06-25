package com.sxtsoft.sqlitehelloworld;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    EditText et1;
    EditText et2;
    EditText et3;

    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);

        b1 = (Button) findViewById(R.id.idBoton1);
        b2 = (Button) findViewById(R.id.idBoton2);

        myDB = new DatabaseHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nombre = et1.getText().toString();
                String apellido1 = et2.getText().toString();
                String apellido2 = et3.getText().toString();

                //crearemos un amigo...
                String nombreCompleto = apellido1 + " " + apellido2 + " " + nombre;

                Toast.makeText(MainActivity.this, nombreCompleto, Toast.LENGTH_LONG).show();

                myDB.insertData(nombre, apellido1, apellido2);

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Cursor cursor = myDB.getAll();

                //Que hace un cursor aquí... :-(
                if (cursor == null || cursor.getCount() == 0){
                    Log.d("**LISTAR", "onClick botonlistar, sin datos");
                    return;
                }

                while (cursor.moveToNext()){
                    int codigo = cursor.getInt(0);
                    String nombre = cursor.getString(1);
                    String apellido1 = cursor.getString(2);
                    String apellido2 = cursor.getString(3);

                    String amigo = codigo + ": " + nombre + " " + apellido1 + " " + apellido2;
                    Log.d("**LISTAR", amigo);

                }
            }
        });

    }
}
