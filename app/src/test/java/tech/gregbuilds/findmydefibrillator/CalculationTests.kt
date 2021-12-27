package tech.gregbuilds.findmydefibrillator

import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.gms.maps.model.LatLng
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tech.gregbuilds.findmydefibrillator.model.Defibrillator

@RunWith(AndroidJUnit4::class)
class CalculationTests {
    @get:Rule
    var activity = ActivityScenarioRule(FindNearestDefibrillator::class.java)
    @Test
    fun find_nearest_defib_is_correct(){
        //val scenario = activity.scenario.moveToState(Lifecycle.State.CREATED)
        //scenario.result.route
        //FindNearestDefibrillator().routeToNearestDefibrillator()
        val defib1 = Defibrillator("Closest Defib", R.drawable.kings, LatLng(1.0, 2.0))
        val defib2 = Defibrillator("Furthest Defib", R.drawable.kings, LatLng(1.0, 3.0))
        val currentLocation = LatLng(1.0, 0.0)
        val testDefibs = listOf<Defibrillator>(defib1, defib2)

        val returnValue = FindNearestDefibrillator().routeToNearestDefibrillator(currentLocation, testDefibs)
        assertEquals(returnValue, defib1)
        assertEquals(returnValue, defib1)

    }
}