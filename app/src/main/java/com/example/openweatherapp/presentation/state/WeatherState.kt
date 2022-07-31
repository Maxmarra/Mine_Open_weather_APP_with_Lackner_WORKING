package com.example.openweatherapp.presentation.state

import com.example.openweatherapp.domain.weather.WeatherData

data class WeatherState(
    val weatherData: List<WeatherData>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
