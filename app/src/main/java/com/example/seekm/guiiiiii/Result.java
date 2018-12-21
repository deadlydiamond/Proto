package com.example.seekm.guiiiiii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView longitude,latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        latitude = (TextView)findViewById(R.id.latitude);
        longitude = (TextView)findViewById(R.id.longitude);


        Intent intent = getIntent();
        latitude.setText("Latitude: " + intent.getStringExtra("Latitude"));
        longitude.setText("Longitude: " + intent.getStringExtra("Longitude"));
    }
}
