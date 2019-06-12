package com.sxtsoft.calculadora;

import android.util.Log;

public class Operation {

    double numResult;
    double numTecleado1;
    double numTecleado2;

    String operacion;


    public Operation() {
        this.numResult = 0.0;
    }

    public double getNumResult() {

        return numResult;
    }

    public void iniciarCalc(){
        //se pondrá a cero la calculadora
        this.numResult = 0.0;

    }

    public void setNumTecleado1(double numTecleado1) {

        this.numTecleado1 = numTecleado1;
        Log.d("CALCULADORA", "Numero Tecledo1: " + String.valueOf(this.numTecleado1));
    }

    public void setNumTecleado2(double numTecleado2) {

        this.numTecleado2 = numTecleado2;
        Log.d("CALCULADORA", "Numero Tecledo2: " + String.valueOf(this.numTecleado2));
    }

    public String getOperacion() {

        return operacion;
    }

    public void setOperacion(String operacion) {

        this.operacion = operacion;
    }

    public void realizarOperacion() {

        switch (this.operacion) {

            case "sumar":

                this.numResult = this.numResult + this.numTecleado1;
                Log.d("*CALCULADORA", String.valueOf(this.numResult));
                break;

            case "restar":

                this.numResult =  this.numTecleado1 - this.numResult;
                Log.d("*CALCULADORA", String.valueOf(this.numResult));
                break;
            //System.out.println(this.n1+" "+this.operacion+" "+this.n2+" = "+this.res);

        }
    }
}