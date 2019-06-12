package com.sxtsoft.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult;
    double valor = 0.0;
    double valorView = 0.0;
    StringBuilder stringBuilder = new StringBuilder();

    //private Double valorBoton = 0.0; //cargaré el valor presionado de la tecla
    Operation operation = new Operation(); //creo este artefacto que me permitirá realizar las operaciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = (TextView) findViewById(R.id.viewResult);
        operation.setEstado(true); //inicio el estado en la calcu

    }

    public void botonPulsado(View view){

        int cifra = 0;
        valorView = Double.parseDouble((String)textViewResult.getText());

        String accion = "";

        switch (view.getId()){

            case R.id.idBoton0:
                cifra = 0;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton1:
                cifra = 1;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton2:
                cifra = 2;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton3:
                cifra = 3;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton4:
                cifra = 4;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton5:
                cifra = 5;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton6:
                cifra = 6;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton7:
                cifra = 7;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton8:
                cifra = 8;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBoton9:
                cifra = 9;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBotonPlus:
                //pasaré el valor tecleado al artefacto

                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));

                if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                //si alguna de ellas es verdadera se debe hacer
                operation.realizarOperacion();
                Log.d("*CALCULADORA","Se realizó la suma");
                }else {
                    operation.setOperacion("sumar");
                    operation.realizarOperacion();
                }

                stringBuilder.setLength(0);
                Toast.makeText(getApplicationContext(), "pulsado +", Toast.LENGTH_LONG).show();

                break;

            case R.id.idBotonMinus:
                //pasaré el valor tecleado al artefacto

                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));

                if (operation.getEstado() == true){
                    //debo avisar que realice la operación
                    //con respecto al inicio
                    operation.setNumResult((Double.parseDouble(stringBuilder.toString())));
                    Toast.makeText(getApplicationContext(), "estado inicial", Toast.LENGTH_LONG).show();
                    operation.setOperacion("restar");
                    operation.setEstado(false);

                } else if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                //si alguna de ellas es verdadera se debe hacer
                operation.realizarOperacion();
                    Toast.makeText(getApplicationContext(), "realizo la operación", Toast.LENGTH_LONG).show();

                } else {
                    operation.setOperacion("restar");
                    operation.realizarOperacion();
                }

                stringBuilder.setLength(0);
                Toast.makeText(getApplicationContext(), "pulsado -", Toast.LENGTH_LONG).show();
                break;

            case R.id.idBotonPor:
                //pasaré el valor tecleado al artefacto

                //si ya hay una operación debo hacerla (cualquier operación)
                //para cambiar el resultado antes de continuar con otra operación
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));

                if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                    //si alguna de ellas es verdadera se debe hacer
                    operation.realizarOperacion();
                }else {
                    operation.setOperacion("multiplicacion");
                    operation.realizarOperacion();
                }

                stringBuilder.setLength(0);
                //Toast.makeText(getApplicationContext(), "pulsado -", Toast.LENGTH_LONG).show();
                break;

            case R.id.idBotonDiv:
                //pasaré el valor tecleado al artefacto

                //si ya hay una operación debo hacerla (cualquier operación)
                //para cambiar el resultado antes de continuar con otra operación
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));

                if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                    //si alguna de ellas es verdadera se debe hacer
                    operation.realizarOperacion();
                }else {
                    operation.setOperacion("division");
                }

                stringBuilder.setLength(0);
                Toast.makeText(getApplicationContext(), "pulsado / estado" + operation.getEstado(), Toast.LENGTH_LONG).show();
                break;

            case R.id.idBotonIgual:

                //if (operation.getEstado() == true){
                //    operation.setNumTecleado2(Double.parseDouble(stringBuilder.toString()));
                //    operation.realizarOperacion();
                //    operation.setEstado(false);
                //}else{
                //asigno el valor tecleado
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));

                operation.realizarOperacion();
                //}

                valor = operation.getNumResult();
                textViewResult.setText(String.valueOf(valor));

                operation.iniciarCalc();
                stringBuilder.setLength(0);

                break;
        }

   }


}
