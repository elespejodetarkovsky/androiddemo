package com.sxtsoft.accesocamara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirCamara;
    private Button btnGuardarFoto;
    private ImageView imageView;

    //tambien guradermos en una variable de instancia la imagen actual

    private Bitmap imagenActual = null; //aunque no es necesario poner null...por defecto son null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirCamara = (Button) findViewById(R.id.btnCamara);
        btnGuardarFoto = (Button) findViewById(R.id.btnGurdar);
        imageView = (ImageView) findViewById(R.id.imageView);

        btnAbrirCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });

        btnGuardarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFoto();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK){

            Bundle extras = data.getExtras(); //ya tengo referencia al bundle
            Bitmap imageBitmap = (Bitmap) extras.get("data"); //lo de "data" hay que saberlo.

            imageView.setImageBitmap(imageBitmap);

            //como posiblemente guarde el bitmap en el sistema de archivos
            //me interesará también guardar en variable de instancia
            //de esta misma activity

            imagenActual = imageBitmap;
        }

    }

    private void abrirCamara(){

        //se trata de un intent ya deficinido en el sistema.
        Intent hacerFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Estamos comprobando si la aplicacion de la camara se abre con normalidad
        if (hacerFotoIntent.resolveActivity(getPackageManager()) != null){
            //abrir la camara

            startActivityForResult(hacerFotoIntent,1);
        }

    }


    private File createImageFile() throws IOException {

        String strName = "name" + ((int)(Math.random()*10000));

        //El constructor de File necesita saber
        //1. El directorio (en este caso el dir de nuestra app...
        //2. necesita conocer el nombre del archivo

        File file = new File(this.getFilesDir(), strName);

        return file;
    }

    private void guardarFoto(){
        try{

            File file = createImageFile();
            Log.d("**", "file: " + file.getAbsolutePath());

            //Un File OutputStream es un IS-A un OutputStream especializado en archivos

            OutputStream out = new FileOutputStream(file);

            //Ahora vamos a "enviar" la imagenActual a traves del stream...

            imagenActual.compress(Bitmap.CompressFormat.JPEG, 100, out);

            out.flush();
            out.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
