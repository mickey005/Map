package com.example.android.myapp3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap g_map;
    boolean mapReady=false;


    static final CameraPosition NEWYORK = CameraPosition.builder()
            .target(new LatLng(40.784,-73.9857))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.3491))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478,-6.2597))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();


    static final CameraPosition TOKYO = CameraPosition.builder()
            .target(new LatLng(35.6895,139.6917))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIndia = (Button)findViewById(R.id.btnIndia);
        btnIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady)
                {
                   flyTo(SEATTLE);

                }
            }
        });

        Button btnUsa = (Button)findViewById(R.id.btnUsa);
        btnUsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady)
                {
                    flyTo(DUBLIN);

                }
            }
        });

        Button btnNewYork = (Button)findViewById(R.id.btnNewyork);
        btnNewYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady)
                {

                    flyTo(TOKYO);

                }
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady=true;
        g_map=googleMap;

        g_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        flyTo(NEWYORK);


    }

    private void flyTo(CameraPosition target)
    {
        g_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),10000,null);
    }
}
