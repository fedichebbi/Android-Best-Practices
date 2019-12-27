package com.example.tutorialreso.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tutorialreso.data.repository.ForecastRepository

class CurrentWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository) as T
    }
}