package com.sxtsoft.registros;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiDisplayView extends LinearLayout {

    private double celsius = 0;

    private TextView celciusTextView;
    private TextView fahrengheitTextView;
    private TextView cityTextView;

    public MiDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //para obtener y inflar el layout
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.mi_display_layaout,this);

        celciusTextView = (TextView) findViewById(R.id.lblCelsius);
        fahrengheitTextView = (TextView) findViewById(R.id.lblFarhengheit);
        cityTextView = (TextView) findViewById(R.id.lblCity);

    }


    public void setCity(String city){
        this.cityTextView.setText(city);
    }

    public void setCelsius(double celsius){
        this.celciusTextView.setText(String.valueOf(celsius));

        double fahrenheit = (celsius * 9/5) + 32;

        fahrengheitTextView.setText(String.valueOf(fahrenheit));
    }

    public void setFahrengheit (double fahrengheit){
        this.fahrengheitTextView.setText(String.valueOf(fahrengheit));

        double celsius = (fahrengheit * 5/9) -32;

        celciusTextView.setText(String.valueOf(celsius));

    }




}
