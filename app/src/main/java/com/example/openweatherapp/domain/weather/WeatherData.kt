package com.example.openweatherapp.domain.weather

import java.time.LocalDateTime

//Это чистый собранный из кусочков JSONa класс
// из WeatherDto.kt
// здесь собрана вся нужная инфа из джейсона
data class WeatherData (
    val temperatureF: Int,
    val humidityF: Int,
    val descriptionF: String,
    val iconF: String,
    val speedF: Int,
    val dateTimeUnixF: Long,
)