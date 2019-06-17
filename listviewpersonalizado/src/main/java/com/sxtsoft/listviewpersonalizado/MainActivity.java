package com.sxtsoft.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView lista;

//    private String[][] datos = {
//            {"America", "Canada"},
//            {"America", "Estados Unidos"},
//            {"America", "Mexico"},
//            {"America", "Nicaragua"},
//            {"America", "Venezuela"},
//            {"America", "Hong Kong 65", "200min","10","blabola1"},
//            {"Fan ho", "Hong Kong 59", "200min","9","blaasbola1"},
//            {"Fan ho", "Hong Kong 66", "200min","7","blaasdbola1"},
//            {"Fan ho", "China 67", "200min","10","aadadvvvdf"}
//    };

        private String[][] datos = {
            {"America", "Canada"},
            {"America", "Estados Unidos"},
            {"America", "Mexico"},
            {"America", "Nicaragua"},
            {"America", "Venezuela"},
            {"America", "Uruguay"},
            {"America", "Argentina"},
            {"America", "Brasil"},
            {"Africa", "Marruecos"},
                {"Africa", "Argelia"},
                {"Africa", "Guinea"},
                {"Africa", "Egipto"},
                {"Africa", "Uganda"},
                {"Europa", "España"},
                {"Europa", "Francia"},
                {"Europa", "Rusia"},
                {"Europa", "Turquía"}
                {"Asia", "China"},
                {"Asia", "Japón"},
                {"Asia", "Corea"}
   };


    private int[] datosimg = {

            R.drawable.,
            R.drawable.tarkovsky2,
            R.drawable.tarkovsky3,
            R.drawable.tarkovsky4,
            R.drawable.tarkovsky5,
            R.drawable.fanho1,
            R.drawable.fanho2,
            R.drawable.fanho3,
            R.drawable.fanho4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idMiLista);

        //En esta clase SOLO FALTA UNA LINEA DE CODIGO

        Adaptador adaptador = new Adaptador(this, datos, datosimg);

        lista.setAdapter(adaptador);
    }
}
