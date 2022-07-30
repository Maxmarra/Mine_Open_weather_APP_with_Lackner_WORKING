package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.domain.util.Resource
import com.example.openweatherapp.domain.weather.WeatherData
import com.example.openweatherapp.domain.weather.WeatherDataCurrent

interface WeatherRepository {

    suspend fun getWeatherForecast(
        lat: Double, long: Double, appId: String
    ): Resource<List<WeatherData>>

    suspend fun getCurrentWeather(
        lat: Double, long: Double, appId: String
    ): Resource<WeatherDataCurrent>
}