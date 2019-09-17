package com.sxtsoft.micontadorpassword.model;

public class Clave {

    private String clave;

    public Clave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {

        /*
        Devería evaluar cual es la complejidad de la calve
        TODO
         */
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Clave{" +
                "clave='" + clave + '\'' +
                '}';
    }
}
