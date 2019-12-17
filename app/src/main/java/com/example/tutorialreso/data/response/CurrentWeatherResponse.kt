package com.example.tutorialreso.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrenWeatherEntry,
    val location: Location,
    val request: Request
)