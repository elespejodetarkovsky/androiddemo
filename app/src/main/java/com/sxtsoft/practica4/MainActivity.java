package com.sxtsoft.practica4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTime;
    private Date fecha = new Date();

    static {
        Log.d("Info", "Se inicializa el 'mundo estático'");
    }

    public MainActivity(){
        Log.d("Info", "Dentro del método constructor'");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Info", "Dentro de 'onCreate'");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTime = (TextView) findViewById(R.id.idTextViewTime);
        textViewTime.setText("0 seg Inactivo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        fecha = new Date();
        Log.d("INFO", "ON PAUSE valor " + fecha);
    }

    @Override
    protected void onResume() {
        super.onResume();
        long fin = (new Date().getTime() - fecha.getTime());

        StringBuilder sb = new StringBuilder();
        sb.append(fin).append(" Seg en pausa");
        //finalTime = (int)(fin - inicioTime) / 1000;
        Log.d("INFO", "ON RESUME " + fin);
        textViewTime.setText(sb.toString());
    }
}
