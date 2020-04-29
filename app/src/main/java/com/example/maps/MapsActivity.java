package com.example.maps;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng sdnm4 = new LatLng(-7.124056, 112.388526);
        mMap.addMarker(new MarkerOptions().position(sdnm4).title("SD Negeri Made 3 Lamongan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sdnm4));

        LatLng Made_Lamongan = new LatLng(-7.124056, 112.389567);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Made_Lamongan, 17));
        mMap.setMapStyle(new MapStyleOptions(getResources().getString(R.string.style_json)));
    }
}
