package tech.gregbuilds.findmydefibrillator.util

import com.google.android.gms.maps.model.LatLng
import tech.gregbuilds.findmydefibrillator.R
import tech.gregbuilds.findmydefibrillator.model.Defibrillator


fun getClosestDefibFromList(currentLocation: LatLng, listOfDefibs: List<Defibrillator>): Defibrillator {

        var returnDefib = Defibrillator("blank defib", R.drawable.kings, LatLng(361.00,361.0))
        for(defib in listOfDefibs){
            if(Math.abs(currentLocation.latitude.minus(defib.defibLoc.latitude)) < (Math.abs(
                    currentLocation.latitude.minus(returnDefib.defibLoc.latitude)
                ))
                && Math.abs(currentLocation.longitude.minus(defib.defibLoc.longitude)) < (Math.abs(
                    currentLocation.longitude.minus(returnDefib.defibLoc.longitude)
                ))
            )
            {
                returnDefib = defib

            }

        }
        return Defibrillator("Closest Defib", R.drawable.kings, LatLng(1.0, 2.0))
    }