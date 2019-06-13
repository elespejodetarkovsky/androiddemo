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
    private Operation operation = new Operation(); //creo este artefacto que me permitirá realizar las operaciones
    private boolean presionadoIgual = false;

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
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton1:
                cifra = 1;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton2:
                cifra = 2;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton3:
                cifra = 3;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton4:
                cifra = 4;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton5:
                cifra = 5;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton6:
                cifra = 6;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton7:
                cifra = 7;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton8:
                cifra = 8;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBoton9:
                cifra = 9;
                stringBuilder.append(cifra);
                textViewResult.setText(stringBuilder.toString());
                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));
                break;

            case R.id.idBotonPunto:
                stringBuilder.append(".");
                textViewResult.setText(stringBuilder.toString());
                break;

            case R.id.idBotonCE:
                stringBuilder.setLength(0);
                textViewResult.setText(stringBuilder.toString());
                textViewResult.setText("0.0");
                break;

            case R.id.idBotonON:
                stringBuilder.setLength(0);
                operation.iniciarCalc();
                textViewResult.setText("0.0");
                break;

            case R.id.idBotonPlus:
                //pasaré el valor tecleado al artefacto

                if (operation.getEstado() == true) {
                    //debo avisar que realice la operación
                    //con respecto al inicio
                    operation.setOperacion("sumar");
                    operation.setNumResult(operation.getNumTecleado1()); //le paso el valor al primer término sólo la primera vez
                    operation.setEstado(false);
                } else if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                //si alguna de ellas es verdadera se debe hacer
                operation.realizarOperacion();
                operation.setOperacion("sumar");
                Log.d("*CALCULADORA","Se realizó la suma");
                }else {
                    operation.setOperacion("sumar");
                    operation.realizarOperacion();
                }

                stringBuilder.setLength(0);
                //Toast.makeText(getApplicationContext(), "pulsado +", Toast.LENGTH_LONG).show();

                break;

            case R.id.idBotonMinus:
                //pasaré el valor tecleado al artefacto


                if (operation.getEstado() == true){
                    //debo avisar que realice la operación
                    //con respecto al inicio
                    operation.setOperacion("restar");
                    operation.setNumResult(operation.getNumTecleado1()); //le paso el valor al primer término sólo la primera vez
                    operation.setEstado(false);

                } else if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                    //si alguna de ellas es verdadera se debe hacer
                    operation.realizarOperacion();
                    operation.setOperacion("restar");
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


                if (operation.getEstado() == true){
                    //debo avisar que realice la operación
                    //con respecto al inicio
                    operation.setOperacion("multiplicacion");
                    operation.setNumResult(operation.getNumTecleado1()); //le paso el valor al primer término sólo la primera vez
                    operation.setEstado(false);

                } else if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                    //si alguna de ellas es verdadera se debe hacer
                    operation.realizarOperacion();
                    operation.setOperacion("multiplicacion");
                    Toast.makeText(getApplicationContext(), "realizo la operación", Toast.LENGTH_LONG).show();

                } else {
                    operation.setOperacion("multiplicacion");
                    operation.realizarOperacion();
                }

                stringBuilder.setLength(0);

                break;

            case R.id.idBotonDiv:
                //pasaré el valor tecleado al artefacto

                operation.setNumTecleado1((Double.parseDouble(stringBuilder.toString())));

                if (operation.getEstado() == true){
                    //debo avisar que realice la operación
                    operation.setNumResult(operation.getNumTecleado1()); //le paso el valor al primer término sólo la primera vez
                    operation.setOperacion("division");
                    operation.setEstado(false);

                } else if (operation.getOperacion().equals("multiplicacion") || operation.getOperacion().equals("sumar")
                        || operation.getOperacion().equals("restar") || operation.getOperacion().equals("division")){
                    //si alguna de ellas es verdadera se debe hacer
                    operation.realizarOperacion();
                    operation.setOperacion("division");
                    Toast.makeText(getApplicationContext(), "realizo la operación", Toast.LENGTH_LONG).show();

                } else {
                    operation.setOperacion("division");
                    operation.realizarOperacion();
                }

                stringBuilder.setLength(0);
                break;

            case R.id.idBotonIgual:

                //presionadoIgual = true;

                operation.realizarOperacion();
                //Log.d("*CALCULADORA", "Mensaje error en =: " + operation.getMsgError());

                if (operation.getMsgError().equals("")){

                    double tmpResult = operation.getNumResult();
                    textViewResult.setText(String.valueOf(operation.getNumResult()));
                    //inicializo la calculadora y paso el valor a tecla1
                    operation.iniciarCalc();
                    operation.setNumTecleado1(tmpResult);
                    //stringBuilder.setLength(0);

                }else{
                    textViewResult.setText(operation.getMsgError());
                }


                break;
        }

   }


}
