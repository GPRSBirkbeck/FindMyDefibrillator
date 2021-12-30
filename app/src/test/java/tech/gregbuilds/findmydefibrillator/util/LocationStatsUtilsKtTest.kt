package tech.gregbuilds.findmydefibrillator.util

import com.google.android.gms.maps.model.LatLng
import org.junit.Assert.*

import org.junit.Test
import tech.gregbuilds.findmydefibrillator.R
import tech.gregbuilds.findmydefibrillator.model.Defibrillator

class LocationStatsUtilsKtTest {

    @Test
    fun getClosestDefibFromList() {

        val testList =
            listOf<Defibrillator>(
                Defibrillator("closest d", R.drawable.kings, LatLng(1.0, 0.0)),
                Defibrillator("furthest d", R.drawable.kings, LatLng(2.0, 0.0)),
            )

        val result = Defibrillator("Closest Defib", R.drawable.kings, LatLng(1.0, 2.0))
        val bad_result = Defibrillator("Closest Defib", R.drawable.kings, LatLng(2.0, 2.0))
        val currentLocation = LatLng(0.0, 0.0)
        assertEquals(tech.gregbuilds.findmydefibrillator.util.getClosestDefibFromList(currentLocation,testList), bad_result)
    }
}