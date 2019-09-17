package com.sxtsoft.customeventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomObject co1 = new CustomObject("pepe");
        CustomObject co2 = new CustomObject("carlota");

        co1.setMyCustomObjectListener(new CustomObject.MyCustomObjectListener() {
            @Override
            public void onDataLoaded(CustomObject customObject) {
                Log.d("**", customObject.toString());

            }
        });

        co2.setMyCustomObjectListener(new CustomObject.MyCustomObjectListener() {
            @Override
            public void onDataLoaded(CustomObject customObject) {
                    Log.d("**", customObject.toString());

            }
        });
    }

}
