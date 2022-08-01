package com.example.openweatherapp.domain.weather

data class WeatherDataCurrent(

    //val lon: Double,
    //val lat: Double,

    //val visibility: Int,

    //val type: WeatherType,

    //val weatherDescGroup: String,
    val weatherDescriptionCurrent: String,
    val weatherIcon: String,

    val temperatureCurrent: Int,
    val feelsLike: Int,
    val pressure: Int,
    val humidity: Int,

    val windSpeed: Int,

    val dateTimeUnix: Long,

    val country: String,
    val sunrise: Long,
    val sunset: Long,

    //val cityId: Long,
    val cityName: String,


)
