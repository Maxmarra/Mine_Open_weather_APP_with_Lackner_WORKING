package com.example.openweatherapp.presentation

import com.example.openweatherapp.domain.weather.WeatherDataCurrent

data class CurrentWeatherState(
    val weatherDataCurrent: WeatherDataCurrent? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
