package com.sxtsoft.accesocontactos;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnLeerContacto;
    private TextView txtContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeerContacto = (Button) findViewById(R.id.button);
        txtContactos = (TextView) findViewById(R.id.textView);

        btnLeerContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos();
            }
        });
    }

    private void obtenerDatos(){

        //Contact.Data es la tabla interna donde se guarda la información
        //de contactos

        //Especificamos las columnas de la proyección.
        //si necesitamos otras cosas tendremos que ir
        //a la documentación.

        String[] columnas = new String[]{
                ContactsContract.Data._ID,
                ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.TYPE,
                ContactsContract.CommonDataKinds.Email.ADDRESS
        };

        String selectionClause = ContactsContract.Data.MIMETYPE +
                "= '" + ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE +
                "' AND '" + ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE + "'";// +
                //"' AND " + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";


        String order = ContactsContract.Data.DISPLAY_NAME + " ASC";


            Cursor cursor = getContentResolver().query(
                    ContactsContract.Data.CONTENT_URI,   //URI de contenido para los contactos
                    columnas,                                //las columnas que nos interesan
                    selectionClause,                         //cláusula del filtro
                    null,                        //pues no envío parámetros
                    order                                    //criterio de ordenación
            );

        //Ahora lo vamos a iterar
        //extraeremos la info

        while (cursor.moveToNext()){
            txtContactos.append("Identificador: " + cursor.getString(0) + "\n");
            txtContactos.append("Nombre: " + cursor.getString(1) + "\n");
            txtContactos.append("Teléfono: " + cursor.getString(2) + "\n");
            txtContactos.append("Tipo Teléfono: " + cursor.getString(3) + "\n");
            txtContactos.append("Email: " + cursor.getString(4) + "\n\n\n");

        }

    }
}
