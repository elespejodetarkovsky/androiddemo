package com.sxtsoft.calculadora;

import android.util.Log;

import java.text.DecimalFormat;

public class Operation {

    double numResult;
    double numTecleado1; //corresponde a la primera parte de la operación
    double numTecleado2; //Corresponde a la segunda parte de la operación
    boolean inicio;
    String msgError = "";
    String operacion = "";


    public Operation() {
        this.numResult = 0.0;
        inicio = true; //cuando incia la calculadora, será importante en la resta
    }

    public String getMsgError(){

        return this.msgError;
    }

    public void setMsgError(String msgError){

        this.msgError = msgError;
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

    public void setNumResult(double numResult) {

        this.numResult = numResult;
        Log.d("*CALCULADORA", "setNumREsult numRes: " + String.valueOf(this.numResult));

    }

    public void iniciarCalc(){
        //se pondrá a cero la calculadora
        this.numTecleado1 = 0.0;
        this.numTecleado2 = 0.0;
        this.numResult = 0.0;
        this.operacion = "";
        this.setEstado(true);
    }

    public void setNumTecleado1(double numTecleado1) {

        this.numTecleado1 = numTecleado1;
        Log.d("*CALCULADORA", "Numero Tecledo1: " + String.valueOf(this.numTecleado1));
    }

    public double getNumTecleado1() {

        return this.numTecleado1;
    }

    public double getNumTecleado2() {

        return numTecleado2;
    }

    public void setNumTecleado2(double numTecleado2) {

        this.numTecleado2 = numTecleado2;
        Log.d("*CALCULADORA", "Numero Tecledo2: " + String.valueOf(this.numTecleado2));
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

                //this.numResult = this.numResult + this.numTecleado1;
                this.numResult = this.numResult + this.numTecleado1;
                Log.d("*CALCULADORA", "NumRes: " + String.valueOf(this.numResult) + "Tecl1: " + this.numTecleado1);
                break;

            case "restar":


                //this.numResult =  this.numResult - this.numTecleado1;
                this.numResult =  this.numResult - this.numTecleado2;
                Log.d("*CALCULADORA", "Resta numRes: " + String.valueOf(this.numResult));
                Log.d("*CALCULADORA", "Resta Tecl: " + String.valueOf(this.numTecleado1));
                break;
            //System.out.println(this.n1+" "+this.operacion+" "+this.n2+" = "+this.res);

            case "multiplicacion":
                DecimalFormat df = new DecimalFormat("#.##########");
                this.numResult =  Math.round(this.numResult * this.numTecleado1*100d)/100d; //this.numResult * this.numTecleado1;
                //this.numResult =  df.format(this.numResult * this.numTecleado1);
                //df.format(this.numResult);

                Log.d("*CALCULADORA", "Multiplicacion numRes: " + String.valueOf(this.numResult));
                Log.d("*CALCULADORA", "Multiplicacion Tecl: " + String.valueOf(this.numTecleado1));
                break;

            case "division":

                Log.d("*CALCULADORA", "Division Tecl: " + String.valueOf(this.numTecleado1));
                try{

                    this.numResult = this.numResult / this.numTecleado1;
                    Log.d("*CALCULADORA", "Division numRes: " + String.valueOf(this.numResult));
                    Log.d("*CALCULADORA", "Division Tecl: " + String.valueOf(this.numTecleado1));

                }catch (Exception e){
                    this.numResult = 0.0;
                    this.msgError = e.getMessage();
                }

                break;
        }
    }
}