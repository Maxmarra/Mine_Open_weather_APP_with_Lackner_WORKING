package com.example.openweatherapp.domain.weather

//Это чистый собранный из кусочков JSONa класс
// из WeatherDto.kt
// здесь собрана вся нужная инфа из джейсона
data class WeatherData (
    //val time: Long,
    val temperature: Double,
    //val feelsLike: Double,
    //val weather: List<Weather>,
    val weatherDescription: String,
    //val speed: Double
    //val dtTxt: String
    val dateTime:Long,
    val type: WeatherType

)