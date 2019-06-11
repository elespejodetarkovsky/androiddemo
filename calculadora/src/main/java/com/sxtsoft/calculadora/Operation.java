package com.sxtsoft.calculadora;

public class Operation {

    double n1;
    double n2;
    String operacion;


    public Operation() {

    }

    public double getN1() {

        return n1;
    }

    public void setN1(double n1) {

        this.n1 = n1;
    }

    public double getN2() {

        return n2;
    }

    public void setN2(double n2) {

        this.n2 = n2;
    }

    public String getOperacion() {

        return operacion;
    }

    public void setOperacion(String operacion) {

        this.operacion = operacion;
    }

    public double realizarOperacion() {

        switch (this.operacion) {

            case "+":

                return this.n1 + this.n2;

            case "-":

                return this.n1 - this.n2;

            //System.out.println(this.n1+" "+this.operacion+" "+this.n2+" = "+this.res);

        }
        return 0.0;
    }
}