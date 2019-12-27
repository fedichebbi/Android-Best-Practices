package com.example.tutorialreso.ui.weather.current

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialreso.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import com.example.tutorialreso.data.repository.ForecastRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    /*val weather : Deferred<LiveData<out UnitSpecificCurrentWeatherEntry>>
        get() {
            viewModelScope.async(start = CoroutineStart.LAZY) {
                val weather = forecastRepository.getCurrentWeather(true)
            }
            return  weather
        }
*/
    val weather : Deferred<LiveData<out UnitSpecificCurrentWeatherEntry>>
    = viewModelScope.async (start = CoroutineStart.LAZY)
    { forecastRepository.getCurrentWeather(true) }
    /*val weather  = viewModelScope.async(start = CoroutineStart.LAZY) {
        forecastRepository.getCurrentWeather(true)
    }*/
}
