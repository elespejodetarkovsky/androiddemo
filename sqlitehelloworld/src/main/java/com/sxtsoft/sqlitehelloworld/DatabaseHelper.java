package com.sxtsoft.sqlitehelloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "amigos.db";
    public static final String AMIGOS_TABLE = "amigos";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "APELLIDO1";
    public static final String COL_4 = "APELLIDO2";


    public DatabaseHelper(Context context){ //, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("*DB*","Estoy en el constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //entramos aquí en este método cuando la db se crea por primera vez
        //se tendrá que ejecutar una sentencia de DDL (Data Definition Languaje)
        /*CREATE TABLE AMIGOS (
        ID          INTEGER PRIMARY KEY AUTOINCREMENT,
        NOMBRE      TEXT NOT NULL,
        APELLIDO1   TEXT,
        APELLIDO2   TEXT
        )
         */

        StringBuilder strSql = new StringBuilder();

        strSql.append("CREATE TABLE ")
                .append(AMIGOS_TABLE).append(" (")
                .append(COL_1).append(" INTEGER PRIMARY KEY AUTOINCREMENT,")
                .append(COL_2).append(" TEXT NOT NULL," )
                .append(COL_3).append(" TEXT NOT NULL,")
                .append(COL_4).append(" TEXT)");

        Log.d("*DB*", strSql.toString());

        db.execSQL(strSql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //entramos aquí cuando se detecta un cambio de versión
        //en la base de datos, normalmente esto provoca
        //la creación de nuevas tblas o columnas en tablas
        //existentes. DROP TABLE elimina la tabla y oncreate()
        //vuelve a crear el esquema desde cero

        db.execSQL("DROP TABLE IF EXISTS " + AMIGOS_TABLE );
        onCreate(db);
    }

    //Metodos para realizar operaciones CRUD

    public boolean insertData(String nombre, String apellido1, String apellido2){

        //necesito una referencia a la base de datos "omo tal.."
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, apellido1);
        contentValues.put(COL_4, apellido2);

        long resultado = db.insert(AMIGOS_TABLE, null, contentValues);

        //si resultado =-1 es que algo fue mal...
        //si resultado es >= 0 el numero de registros afectados

        return resultado == -1 ? false: true;
    }

    public Cursor getAll(){

        //necesito una referencia a la base de datos "omo tal.."
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AMIGOS_TABLE, null);


        //Qué es selectionArgs
        //Es un array de string[]
        //En la consulta puede haber interrogantes que serán substitidos
        //por los valores de estos string

        //Ejemplo
        //SELECT * FROM AMIGOS WHERE NOMBRE=? AND APELLIDO1 LIKE ?%
        //Sring[] = ["Adolfo","D"]

        return cursor;
    }

}
