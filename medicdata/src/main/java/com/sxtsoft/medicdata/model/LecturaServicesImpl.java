package com.sxtsoft.medicdata.model;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LecturaServicesImpl implements LecturaServices{




    private  static final Map<Integer, Lectura> LECTURAS;

    private static final LecturaServicesImpl INSTANCE = new LecturaServicesImpl();

    static {

        LECTURAS = new TreeMap<>();

        SimpleDateFormat adf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        //SimpleDateFormat adf = new SimpleDateFormat(("EEE, MMM d,HH:mm, ''yyyy"));

        Date fecha0 = null;
        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
        Date fecha5 = null;
        Date fecha6 = null;
        Date fecha7 = null;
        Date fecha8 = null;
        Date fecha9 = null;

        try {
            fecha0 = adf.parse("01/01/2019 1:20:10");
            fecha1 = adf.parse("02/01/2019 12:20:10");
            fecha2 = adf.parse("03/01/2019 11:19:10");
            fecha3 = adf.parse("22/01/2019 15:23:10");
            fecha4 = adf.parse("05/01/2019 09:22:10");
            fecha5 = adf.parse("06/01/2019 05:13:10");
            fecha6 = adf.parse("07/01/2019 08:20:10");
            fecha7 = adf.parse("08/01/2019 10:30:10");
            fecha8 = adf.parse("09/01/2019 09:35:10");
            fecha9 = adf.parse("10/01/2019 12:25:10");


        } catch (ParseException e) {
            e.printStackTrace();
        }

        Lectura l0 = new Lectura(fecha0, 97.6, 91.2, 105.3,2.15,41.3);
        Lectura l1 = new Lectura(fecha1, 93.6, 90.2, 115.3,2.3,42.0);
        Lectura l2 = new Lectura(fecha2, 95.6, 88.2, 102.3,2.4,41.5);
        Lectura l3 = new Lectura(fecha3, 97.6, 89.2, 99.3,2.9,41.2);
        Lectura l4 = new Lectura(fecha4, 88.6, 79.2, 101.3,2.6,42.3);
        Lectura l5 = new Lectura(fecha5, 97.3, 92.2, 102.3,2.0,43.3);
        Lectura l6 = new Lectura(fecha6, 97.6, 87.2, 107.3,1.8,39.6);
        Lectura l7 = new Lectura(fecha7, 99.6, 92.2, 110.3,2.3,41.3);
        Lectura l8 = new Lectura(fecha8, 97.2, 79.2, 100.3,2.0,41.2);
        Lectura l9 = new Lectura(fecha9, 97.8, 91.2, 125.3,2.15,41.3);

        l0.setCodigo(100);
        l1.setCodigo(101);
        l2.setCodigo(102);
        l3.setCodigo(103);
        l4.setCodigo(104);
        l5.setCodigo(105);
        l6.setCodigo(106);
        l7.setCodigo(107);
        l8.setCodigo(108);
        l9.setCodigo(109);

        //Introduzco en la instancia treemap heredada del MAP
        //las lecturas
        //con la siguiente forma
        //KEY: código VALUES:Lecturas.toString

        LECTURAS.put(l0.getCodigo(),l0);
        LECTURAS.put(l1.getCodigo(),l1);
        LECTURAS.put(l2.getCodigo(),l2);
        LECTURAS.put(l3.getCodigo(),l3);
        LECTURAS.put(l4.getCodigo(),l4);
        LECTURAS.put(l5.getCodigo(),l5);
        LECTURAS.put(l6.getCodigo(),l6);
        LECTURAS.put(l7.getCodigo(),l7);
        LECTURAS.put(l8.getCodigo(),l8);
        LECTURAS.put(l9.getCodigo(),l9);

    }

    private LecturaServicesImpl(){
        //singleTon
    }

    public static  LecturaServicesImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public Lectura create(Lectura lectura) {
        //hemos de calcular el nuevo código
        Integer maxCode = ((TreeMap<Integer, Lectura>) LECTURAS).lastKey();
        Integer newCode = ++maxCode; //el ++ al principio para que lo agregue antes
        lectura.setCodigo(newCode);
        return LECTURAS.put(lectura.getCodigo(),lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        return LECTURAS.get(codigo);
    }

    @Override
    public Lectura update(Lectura lectura) {
        //me tiene que llegar una lectura con codigo existente!

        boolean lecturaExiste = LECTURAS.containsKey(lectura.getCodigo());
        if (lectura.getCodigo() == null || !lecturaExiste){
            throw new IllegalArgumentException("no existe la lectura");
        }

        return LECTURAS.put(lectura.getCodigo(), lectura);
    }

    @Override
    public boolean delete(Integer codigo) {
        Lectura lectura = LECTURAS.remove( codigo);
        return lectura == null ? false: true;
    }

    @Override
    public List<Lectura> getAll() {
        List<Lectura> lecturas = new ArrayList<>(LECTURAS.values());

        Collections.sort(lecturas, new Comparator<Lectura>() {

            @Override
            public int compare(Lectura lectura0, Lectura lectura1) {
                return lectura1.getCodigo() - lectura0.getCodigo();
            }
        });

        return lecturas;
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {

        List<Lectura> lecturas = new ArrayList<>();

        for(Lectura lectura: getAll()){ //this.getAll()

            Date fechaHora = lectura.getFechaHora();
            if (fechaHora.after(fecha1) && fechaHora.before(fecha2)){
                lecturas.add(lectura);
            }
        }
        return lecturas;
    }

}
