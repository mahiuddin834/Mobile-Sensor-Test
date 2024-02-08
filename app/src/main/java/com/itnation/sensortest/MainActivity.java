package com.itnation.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{

    MaterialButton btnAccelerometer, btnProximity, btnAmbientLight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAccelerometer = findViewById(R.id.btnAccelerometer);
        btnProximity = findViewById(R.id.btnProximity);
        btnAmbientLight = findViewById(R.id.btnAmbientLight);



        btnAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AccelerometerActivity.class));

            }
        });

        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ProxinitySensorActivity.class));
            }
        });

        btnAmbientLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), AmbientLightActivity.class));

            }
        });



    }



}