package tech.gregbuilds.findmydefibrillator.data

import com.google.android.gms.maps.model.LatLng
import tech.gregbuilds.findmydefibrillator.R
import tech.gregbuilds.findmydefibrillator.model.Defibrillator

class LocationData {
    fun LoadDefibLocations(): List<Defibrillator>{
        return listOf<Defibrillator>(
            Defibrillator("Edgware Road", R.drawable.kings, LatLng(51.519732, -0.167428)),
            Defibrillator("Baker Street", R.drawable.kings, LatLng(51.524451, -0.158839)),
            Defibrillator("Oxford Circus 2", R.drawable.kings, LatLng(51.515319, -0.141915)),
            Defibrillator("Baker Street 2", R.drawable.kings, LatLng(51.522469, -0.156998)),
            Defibrillator("Westminster", R.drawable.kings, LatLng(51.500994, -0.124845))
        )
    }
}