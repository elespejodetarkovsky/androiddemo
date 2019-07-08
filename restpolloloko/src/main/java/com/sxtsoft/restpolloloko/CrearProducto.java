package com.sxtsoft.restpolloloko;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.sxtsoft.restpolloloko.R;

public class CrearProducto extends AppCompatActivity {

    TextView name;
    TextView id;
    TextView descripcion;
    TextView fechaAlta;
    Spinner categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

    }

}
