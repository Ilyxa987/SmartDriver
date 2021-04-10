package com.example.test;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BlendMode;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    Location location;
    private final int LOCATION_PERMISSION = 4521;
    private boolean granted = false;
    LatLng myPlace;


    private boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION);
            return false;
        }
        return true;
    }

    public boolean isGranted() {
        return granted;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION) {
            granted = true;
            if (grantResults.length > 0) {
                for (int res : grantResults) {
                    if (res != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Access denied", Toast.LENGTH_SHORT).show();
                        granted = false;
                    }
                }
            } else {
                Toast.makeText(this, "Access denied", Toast.LENGTH_SHORT).show();
                granted = false;
            }
        }
    }

    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            if(location != null) {
                mMap.addMarker(new MarkerOptions().position(myPlace).title("Number bus"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myPlace));
                showLocation(location);
                Toast.makeText(MapsActivity.this, location.getLongitude() + " " + location.getLatitude(), Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MapsActivity.this, "Местоположение не определено", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            Toast.makeText(getApplicationContext(),
                    "Status: " + i,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderEnabled(String s) {
            if (granted || checkPermission())
                showLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
            Toast.makeText(MapsActivity.this, "Местоположение не определено", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String s) {
            Toast.makeText(MapsActivity.this, "Местоположение не определено", Toast.LENGTH_LONG).show();
        }
    };

    private void showLocation(Location location) {
        if (location == null)
            return;
        if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
            this.location = location;
            //показать!!!
            Toast.makeText(this, location.getLongitude() + " " + location.getLatitude(), Toast.LENGTH_SHORT).show();
            myPlace = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(myPlace).title("Number bus"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(myPlace));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
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

        LatLng irkutsk = new LatLng(52, 104);
        mMap.addMarker(new MarkerOptions().position(irkutsk).title("Number bus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(irkutsk));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (granted || checkPermission()) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    myPlace = new LatLng(location.getLatitude(), location.getLongitude());
                }
            }
        }

        // Add a marker in Sydney and move the camera
        if (myPlace != null) {
            mMap.addMarker(new MarkerOptions().position(myPlace).title("Number bus"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(myPlace));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem(R.id.item_profile).setIntent(new Intent(this, ProfileActivity.class));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        super.onOptionsItemSelected(item);
        startActivity(item.getIntent());
        return true;
    }
}