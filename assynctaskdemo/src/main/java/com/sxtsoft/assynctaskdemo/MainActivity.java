package com.sxtsoft.assynctaskdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText tiempo;
    private TextView resultadoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiempo = (EditText) findViewById(R.id.idTiempo);
        button = (Button) findViewById(R.id.idBotonIniciar);
        resultadoFinal = (TextView) findViewById(R.id.idResultadoFinal);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MiAsyncTask miAsyncTask = new MiAsyncTask();
                String sleepTime = tiempo.getText().toString();
                miAsyncTask.execute(sleepTime);
            }
        });

    }


    //Clase interna para definir la AssyncTask
    private class MiAsyncTask extends AsyncTask<String, String, String>{


        ProgressDialog progressDialog;
        private String respuesta;

        @Override
        protected String doInBackground(String... parametros) {

            try {

                //parsear el tiempo...
                int tiempo = Integer.parseInt(parametros[0]) * 1000;

                Thread.sleep(tiempo);
                publishProgress("Siesta 1 terminada...");

                Thread.sleep((tiempo));
                publishProgress("Siesta 2 terminada...");

                Thread.sleep(tiempo);
                publishProgress("Siesta 3 terminada...");


                respuesta = "Hemos dormido " + tiempo/1000 + " segundos";

            } catch (Exception e){
                respuesta = "Algo ha ido mal...";
            }

            return respuesta;
        }

        //metodo de inicialización. Se ejecuta antes de que la tarea
        //se inicie.
        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this,"toca esperar","Esperamos "
                    + tiempo.getText().toString()
                    + " segundos");

        }

        @Override
        protected void onPostExecute(String s) {
            //la s recoge el valor que devuelve
            //el método doInBackground


            //quitamos del medio el progressDialog...

            progressDialog.dismiss();

            //ponemos el resultado en un textview de la
            //main activity

            resultadoFinal.setText(s);
        }



        @Override
        protected void onProgressUpdate(String... values) {
            progressDialog.setMessage(values[0]);
        }
    }
}
