package com.sxtsoft.micontadorpassword;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiClaveRowView extends LinearLayout {

    private TextView fortalezaClave;
    private EditText clave;

    public MiClaveRowView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //para obtener y inflar el layout
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.mi_display_layout,this);

        clave = (EditText) findViewById(R.id.txtClave);
        fortalezaClave = (TextView) findViewById(R.id.lblClave);

        clave.addTextChangedListener(new TextWatcher() {

            /*
            evento que surgirá al realizar
            cambios en el texto
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*
                aquí llamaré a la función que analizará la escritura
                 */
                analizarClave(s.toString(), count);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    private void analizarClave(String clave, int count){
        Log.d("**", "Clave: " + clave + " " + count);

        if (clave.length() > 10){
            fortalezaClave.setTextColor(Color.GREEN);
            fortalezaClave.setText("fuerte");
        }
    }

    public void setClave(String clave){
        this.clave.setText(clave);
    }


}