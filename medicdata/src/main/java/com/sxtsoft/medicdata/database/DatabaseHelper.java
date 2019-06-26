package com.sxtsoft.medicdata.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sxtsoft.medicdata.model.Lectura;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MEDICDATA.DB";
    private static final String LECTURAS_TABLE = "LECTURAS";

    private static final String COL_0 = "CODIGO";
    private static final String COL_1 = "FECHA_HORA";
    private static final String COL_2 = "PESO";
    private static final String COL_3 = "DIASTOLICA";
    private static final String COL_4 = "SISTOLICA";
    private static final String COL_5 = "LONGITUD";
    private static final String COL_6 = "LATITUD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*  CREATE TABLE LECTURAS(

           0     CODIGO      INTEGER PRIMARY KEY AUTOINCREMENT,
           1     FECHA_HORA  TEXT NOT NULL,
           2     PESO        REAL NOT NULL,
           3     DIASTOLICA  REAL NOT NULL,
           4     SISTOLICA   REAL NOT NULL,
           5     LONGITUD    REAL,
           6     LATITUD     REAL) */

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + LECTURAS_TABLE + " (")
                .append(COL_0).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(COL_1).append(" TEXT NOT NULL, ")
                .append(COL_2).append(" REAL NOT NULL, ")
                .append(COL_3).append(" REAl NOT NULL, ")
                .append(COL_4).append(" REAL NOT NULL, ")
                .append(COL_5).append(" REAL, ")
                .append(COL_6).append(" REAL)");

        String strDDL = sb.toString();

        db.execSQL(strDDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LECTURAS_TABLE);
        onCreate(db);
    }


    public Lectura createLectura(Lectura lectura) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //modifico la fecha para que sea "entendible"
        //por el sqllite

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strDate = dateFormat.format(lectura.getFechaHora());

        contentValues.put(COL_1, strDate);
        contentValues.put(COL_2, lectura.getPeso());
        contentValues.put(COL_3, lectura.getDiastolica());
        contentValues.put(COL_4, lectura.getSistolica());
        contentValues.put(COL_5, lectura.getLongitud());
        contentValues.put(COL_6, lectura.getLatitud());

        long resultado = db.insert(LECTURAS_TABLE, null, contentValues);

        lectura.setCodigo((int) resultado);

        Log.d("******", "Vamos a dar de alta: " + lectura.toString());

        return resultado == -1 ? null : lectura;
    }

    public List<Lectura> getAll() {

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LECTURAS_TABLE, null);

        List<Lectura> lecturas = new ArrayList<Lectura>();

        if (cursor != null && cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                Integer codigo = cursor.getInt(0);
                String strFecha = cursor.getString(1);
                double peso = cursor.getDouble(2);
                double diastolica = cursor.getDouble(3);
                double sistolica = cursor.getDouble(4);
                double longitud = cursor.getDouble(5);
                double latitud = cursor.getDouble(6);

                //convierto el String to Date
                Date fecha;

                try {
                    fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strFecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                    fecha = new Date();
                }

                Lectura lectura = new Lectura(fecha, peso, diastolica, sistolica, longitud, latitud);
                lectura.setCodigo(codigo);
                lecturas.add(lectura);

            }

        }

        Log.d("*****", lecturas.toString());

        return lecturas;
    }

    public Lectura readLectura(int id) {
        //Devolverá una lectura en
        //funcion del código suministrado
        SQLiteDatabase db = getWritableDatabase();

        //creo una array de string para luego pasarlo
        //como argumento al select

        String[] campos = new String[]{COL_1, COL_2, COL_3, COL_4, COL_5, COL_6};

        String[] args = new String[]{String.valueOf(id)};

        Cursor cursor = db.query(LECTURAS_TABLE, campos, "CODIGO=?", args, null, null, null);
//        Cursor cursor = db.rawQuery("SELECT * FROM " + LECTURAS_TABLE +
//                " WHERE CODIGO = ? ", args);

        if (cursor != null && cursor.getCount() > 0) {

            cursor.moveToNext();

            //Integer codigo = cursor.getInt(0);

            String strFecha = cursor.getString(0);
            double peso = cursor.getDouble(1);
            double diastolica = cursor.getDouble(2);
            double sistolica = cursor.getDouble(3);
            double longitud = cursor.getDouble(4);
            double latitud = cursor.getDouble(5);

            //convierto el String to Date
            Date fecha;

            try {
                fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strFecha);
            } catch (ParseException e) {
                e.printStackTrace();
                fecha = new Date();
            }

            Lectura lectura = new Lectura(fecha, peso, diastolica, sistolica, longitud, latitud);
            return lectura;

        }

        return null;
    }


    public boolean delete(int codigo) {
        SQLiteDatabase db = getWritableDatabase();

        String[] args = new String[]{String.valueOf(codigo)};

        long resultado = db.delete(LECTURAS_TABLE, "CODIGO=?",args );

        return resultado == -1 ? false : true;

    }


}