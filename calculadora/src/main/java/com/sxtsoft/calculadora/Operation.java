package com.sxtsoft.calculadora;

import android.util.Log;

public class Operation {

    double numResult;
    double numTecleado1;
    double numTecleado2;
    boolean inicio;

    String operacion = "";


    public Operation() {
        this.numResult = 0.0;
        inicio = true; //cuando incia la calculadora, será importante en la resta
    }

    public boolean getEstado(){
        return this.inicio;
    }

    public void setEstado(boolean inicio){
        this.inicio = inicio;
    }

    public double getNumResult() {

        return numResult;
    }

    public void iniciarCalc(){
        //se pondrá a cero la calculadora
        this.numResult = 0.0;
        this.operacion = "";

    }

    public void setNumTecleado1(double numTecleado1) {

        this.numTecleado1 = numTecleado1;
        Log.d("CALCULADORA", "Numero Tecledo1: " + String.valueOf(this.numTecleado1));
    }

    public double getNumTecleado2() {
        return numTecleado2;
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

                this.numResult =  this.numResult - this.numTecleado1;
                Log.d("*CALCULADORA", String.valueOf(this.numResult));
                break;
            //System.out.println(this.n1+" "+this.operacion+" "+this.n2+" = "+this.res);

            case "multiplicacion":

                if (this.inicio == true){
                    Log.d("*CALCULADORA", "Num1: " + String.valueOf(this.numTecleado1) + "*" + String.valueOf(this.numTecleado2));
                    this.numResult =  this.numTecleado1 * this.numTecleado2;
                } else {
                    this.numResult =  this.numResult * this.numTecleado1;
                }

                Log.d("*CALCULADORA", "Multiplicacion: " + String.valueOf(this.numResult) + " " + this.inicio);
                break;

            case "division":

                if (this.inicio == true){
                    Log.d("*CALCULADORA", "Num1: " + String.valueOf(this.numTecleado1) + "/" + String.valueOf(this.numTecleado2));
                    this.numResult =  this.numTecleado1 / this.numTecleado2;
                } else {
                    this.numResult =  this.numResult / this.numTecleado1;
                }

                Log.d("*CALCULADORA", "Division: " + String.valueOf(this.numResult) + " " + this.inicio);
                break;
        }
    }
}