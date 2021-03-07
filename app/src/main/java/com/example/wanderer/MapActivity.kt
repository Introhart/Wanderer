package com.example.wanderer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style

class MapActivity : AppCompatActivity() {

    private var mapView : MapView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(applicationContext, getString(R.string.access_token))
        setContentView(R.layout.activity_map)
//        this.supportActionBar?.hide()

        mapView = findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync {
                mapboxMap -> mapboxMap.setStyle(Style.MAPBOX_STREETS) {}
        }

    }
}