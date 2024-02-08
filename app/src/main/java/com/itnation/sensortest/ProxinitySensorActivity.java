package com.itnation.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProxinitySensorActivity extends AppCompatActivity implements SensorEventListener {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxinity_sensor);

        displayText= findViewById(R.id.displayTextP);



        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {

            Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proximitySensor != null) {

                sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);


            } else {

                Toast.makeText(this, "Sensor not Detected", Toast.LENGTH_SHORT).show();
            }


        }




    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY){

            displayText.setText("Valuse: "+ event.values[0]);

            if (event.values[0]>0){
                Toast.makeText(this, "Values is Far", Toast.LENGTH_SHORT).show();
            }else {

                Toast.makeText(this,"Values is Near", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}