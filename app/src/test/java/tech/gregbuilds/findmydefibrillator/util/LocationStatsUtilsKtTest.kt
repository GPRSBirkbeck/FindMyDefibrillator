package tech.gregbuilds.findmydefibrillator.util

import com.google.android.gms.maps.model.LatLng
import org.junit.Assert.*

import org.junit.Test
import tech.gregbuilds.findmydefibrillator.R
import tech.gregbuilds.findmydefibrillator.model.Defibrillator

class LocationStatsUtilsKtTest {

    @Test
    fun closest_defib_math_1() {
        val currentLocation = LatLng(0.0, 0.0)

        val testList =
            listOf<Defibrillator>(
                Defibrillator("closest d", R.drawable.kings, LatLng(1.0, 0.0)),
                Defibrillator("furthest d", R.drawable.kings, LatLng(2.0, 0.0)),
            )

        val result = Defibrillator("closest d", R.drawable.kings, LatLng(1.0, 0.0))
        assertEquals(getClosestDefibFromList(currentLocation,testList), result)
    }

    @Test
    fun closest_defib_math_2() {
        val currentLocation = LatLng(0.0, 0.0)

        val testList =
            listOf<Defibrillator>(
                Defibrillator("closest d", R.drawable.kings, LatLng(-1.0, 0.0)),
                Defibrillator("furthest d", R.drawable.kings, LatLng(2.0, 0.0)),
            )

        val result = Defibrillator("closest d", R.drawable.kings, LatLng(-1.0, 0.0))
        assertEquals(getClosestDefibFromList(currentLocation,testList), result)
    }

    @Test
    fun closest_defib_math_3() {
        val currentLocation = LatLng(0.0, 0.0)

        val testList =
            listOf<Defibrillator>(
                Defibrillator("closest d", R.drawable.kings, LatLng(-1.0, 0.0)),
                Defibrillator("furthest d", R.drawable.kings, LatLng(-2.0, 0.0)),
            )

        val result = Defibrillator("closest d", R.drawable.kings, LatLng(-1.0, 0.0))
        assertEquals(getClosestDefibFromList(currentLocation,testList), result)
    }

    @Test
    fun closest_defib_math_4() {
        val currentLocation = LatLng(0.0, 0.0)

        val testList =
            listOf<Defibrillator>(
                Defibrillator("closest d", R.drawable.kings, LatLng(-1.0, 0.0)),
                Defibrillator("furthest d", R.drawable.kings, LatLng(-1.0, 1.0)),
            )

        val result = Defibrillator("closest d", R.drawable.kings, LatLng(-1.0, 0.0))
        assertEquals(getClosestDefibFromList(currentLocation,testList), result)
    }
}