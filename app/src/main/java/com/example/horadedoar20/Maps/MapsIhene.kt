package com.example.horadedoar20.Maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.horadedoar20.R
import com.example.horadedoar20.databinding.ActivityMapsIhene2Binding

class MapsIhene : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsIhene2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsIhene2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnMapClickListener(GoogleMap.OnMapClickListener {
            fun onMapClick(latLng: LatLng) {
                var latitude = latLng.latitude;
                var longitude = latLng.longitude;


                mMap.addMarker(
                    MarkerOptions().position(latLng).title("Local").snippet("Descrição")
                )
            }
        })
        val Ihene = LatLng(-8.0501809497796, -34.89284985092591)

        mMap.addMarker(MarkerOptions().position(Ihene).title("Ihene"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ihene, 18F))
    }
}