package tech.gregbuilds.findmydefibrillator.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.gms.maps.model.LatLng

data class Defibrillator(
    val defibrillatorName: String,
    @DrawableRes val defibImageId: Int,
    val defibLoc: LatLng
)