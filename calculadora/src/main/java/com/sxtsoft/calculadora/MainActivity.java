package com.sxtsoft.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private Button button1;
    //private Double valorBoton = 0.0; //cargaré el valor presionado de la tecla
    Operation operation = new Operation(); //creo este artefacto que me permitirá realizar las operaciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = (TextView) findViewById(R.id.viewResult);
        button1 = (Button) findViewById(R.id.idBoton1);

    }

    public void onClickBoton1(){
        Log.d("INFO","Estoy aquí");
        String valorBoton = (String) button1.getText();
        textViewResult.setText(valorBoton);
    }
    private void cargaValor(int valorBoton){
        StringBuilder sb = new StringBuilder();
        //int valor =
        //sb.append(fin).append(" Seg en pausa");
        //finalTime = (int)(fin - inicioTime) / 1000;
        //Log.d("INFO", "ON RESUME " + fin);
        //textViewTime.setText(sb.toString());
    }

}
