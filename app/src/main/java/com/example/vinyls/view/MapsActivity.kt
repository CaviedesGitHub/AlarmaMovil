package com.example.vinyls.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMapClickListener
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    OnMapClickListener, OnMapLongClickListener {
    var txtLatitud: EditText? = null
    var txtLongitud: EditText? = null
    var mMap: GoogleMap? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.vinyls.R.layout.activity_main)
        txtLatitud = findViewById(com.example.vinyls.R.id.txtLatitud)
        txtLongitud = findViewById(com.example.vinyls.R.id.txtLongitud)
        val mapFragment = supportFragmentManager.findFragmentById(com.example.vinyls.R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap!!.setOnMapClickListener(this)
        mMap!!.setOnMapLongClickListener(this)
        val mexico = LatLng(19.8077463, -99.4077038)
        mMap!!.addMarker(MarkerOptions().position(mexico).title("México"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(mexico))
    }

    override fun onMapClick(latLng: LatLng) {
        txtLatitud!!.setText(latLng.latitude.toString())
        txtLongitud!!.setText(latLng.longitude.toString())
        mMap!!.clear()
        val mexico = LatLng(latLng.latitude, latLng.longitude)
        mMap!!.addMarker(MarkerOptions().position(mexico).title(""))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(mexico))
    }

    override fun onMapLongClick(latLng: LatLng) {
        txtLatitud!!.setText(latLng.latitude.toString())
        txtLongitud!!.setText(latLng.longitude.toString())
        mMap!!.clear()
        val mexico = LatLng(latLng.latitude, latLng.longitude)
        mMap!!.addMarker(MarkerOptions().position(mexico).title(""))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(mexico))
    }
}