package com.sxtsoft.medicdata.model;

import android.content.Context;

import com.sxtsoft.medicdata.database.DatabaseHelper;

import java.util.Date;
import java.util.List;

public class LecturaServicesSQLite implements LecturaServices {

    private Context contexto;
    private DatabaseHelper myDB;

    public LecturaServicesSQLite(Context context){
        this.contexto = context;
        myDB = new DatabaseHelper(contexto);
    }

    @Override
    public Lectura create(Lectura lectura) {
        return myDB.createLectura(lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        //TODO
        return myDB.readLectura(codigo);
    }

    @Override
    public Lectura update(Lectura lectura) {
        //TODO
        return myDB.update(lectura);
    }

    @Override
    public boolean delete(Integer codigo) {
        //TODO
        return myDB.delete(codigo);
    }

    @Override
    public List<Lectura> getAll() {
        return myDB.getAll();
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {
        //TODO
        return myDB.getBetweenDates(fecha1, fecha2);
    }
}
