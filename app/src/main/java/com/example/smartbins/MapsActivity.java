package com.example.smartbins;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int MY_REQUEST_INT = 177 ;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {


                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, MY_REQUEST_INT);
            }
            return;
        }
        else {
            mMap.setMyLocationEnabled(true);
        }
        // Add a marker in Sydney and move the camera
        LatLng d1 = new LatLng(28.595001, 77.020022);
        LatLng d2 = new LatLng(28.594878, 77.020025);
        LatLng d3 = new LatLng(28.594892, 77.020035);

        LatLng d4 = new LatLng(28.594888, 77.020039);
        LatLng d5 = new LatLng(28.594898, 77.020045);
        LatLng d6 = new LatLng(28.594858, 77.020065);

        //LatLng d2 = new LatLng(-28.595207, 77.019705);
        mMap.addMarker(new MarkerOptions().position(d1).title("Marker in D1"));
        mMap.addMarker(new MarkerOptions().position(d2).title("Marker in D2"));
        mMap.addMarker(new MarkerOptions().position(d3).title("Marker in D3"));
        mMap.addMarker(new MarkerOptions().position(d4).title("Marker in D4"));
        mMap.addMarker(new MarkerOptions().position(d5).title("Marker in D5"));
        mMap.addMarker(new MarkerOptions().position(d6).title("Marker in D6"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d2));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d1));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d4));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d5));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d6));
        //mMap.addMarker(new MarkerOptions().position(d2).title("Marker in Sydney"));
        //
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(d2));
    }
}
