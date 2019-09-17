package com.sxtsoft.customeventdemo;

import java.util.Timer;
import java.util.TimerTask;

public class CustomObject {

    //definicion del listener (es una clase interna)
    public interface MyCustomObjectListener {
        public void onDataLoaded(CustomObject culpable);
    }

    //variable de instancia que almacena la implementacion del
    //listener

    //private CustomObject customObject;
    private MyCustomObjectListener listener;
    private String nombre;

    //constructor
    public CustomObject(String nombre){
        this.listener = null; //innecesario pues por default es null
        this.nombre = nombre;
        //this.customObject = this;

        //ponemos en marcha esa tarea asincrona tan importante...

        tareaAsincrona();
    }

    private CustomObject getCustomObject(){
        return this;
    }

    private void tareaAsincrona(){
        //vamos a provocar la ejecucion
        //ciclica de codigo cada 3 segundos aprox...

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (listener!=null){

                    int numeroAleatorio = (int) (Math.random() * 1000);

                    //disparamos!!
                    //listener.onDataLoaded(nombre + ": " + numeroAleatorio);
                    listener.onDataLoaded(getCustomObject());

                }
            }
        },0,3000);
    }


    //setter que permite la inyeccion
    public void setMyCustomObjectListener(MyCustomObjectListener listener){
        this.listener = listener;
    }



}
