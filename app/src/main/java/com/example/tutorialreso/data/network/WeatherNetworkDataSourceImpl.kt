package com.example.tutorialreso.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tutorialreso.data.network.response.CurrentWeatherResponse
import com.example.tutorialreso.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val WeatherApiService : WeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = WeatherApiService.getCurrentWeather(location).await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity" , "No internet connection")
        }
    }
}