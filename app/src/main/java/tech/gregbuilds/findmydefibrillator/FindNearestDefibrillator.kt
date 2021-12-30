package tech.gregbuilds.findmydefibrillator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import tech.gregbuilds.findmydefibrillator.data.LocationData
import tech.gregbuilds.findmydefibrillator.databinding.ActivityFindNearestDefibrillatorBinding
import tech.gregbuilds.findmydefibrillator.model.Defibrillator
import tech.gregbuilds.findmydefibrillator.util.getClosestDefibFromList
import java.lang.Math.abs

class FindNearestDefibrillator : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityFindNearestDefibrillatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFindNearestDefibrillatorBinding.inflate(layoutInflater)
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

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val myLocation = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val locationDataLoaded = LocationData().LoadDefibLocations()

        var nearestDefib = getClosestDefibFromList(myLocation, locationDataLoaded)
        //drawRouteToDefib(myLocation, nearestDefib)

    }


/*    fun drawRouteToDefib(currentLocation: LatLng, destinationDefib: Defibrillator){
        //TODO draw a route on the map

        displayTimeToDefib()
    }

    private fun displayTimeToDefib() {
        TODO("Not yet implemented")
    }*/
}