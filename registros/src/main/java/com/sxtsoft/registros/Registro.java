package com.sxtsoft.registros;

public class Registro {

    private String city;
    private double celsius;

    public Registro(){

    }

    public Registro(String city, double celsius){
        this.celsius = celsius;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
}
