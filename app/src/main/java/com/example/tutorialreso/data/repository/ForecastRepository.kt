package com.example.tutorialreso.data.repository

import androidx.lifecycle.LiveData
import com.example.tutorialreso.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric : Boolean) : LiveData<out UnitSpecificCurrentWeatherEntry>
}