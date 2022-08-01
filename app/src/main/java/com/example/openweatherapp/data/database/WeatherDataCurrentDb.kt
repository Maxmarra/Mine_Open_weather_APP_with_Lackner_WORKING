package com.example.openweatherapp.data.database

import androidx.lifecycle.Transformations.map
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.openweatherapp.domain.weather.WeatherDataCurrent

@Entity
data class WeatherDataCurrentDb(
    @PrimaryKey
    val dateTimeUnixDb: Long,
    val weatherDescriptionCurrentDb: String,
    val weatherIconDb: String,
    val temperatureCurrentDb: Int,
    val feelsLikeDb: Int,
    val pressureDb: Int,
    val humidityDb: Int,
    val windSpeedDb: Int,
    val countryDb: String,
    val sunriseDb: Long,
    val sunsetDb: Long,
    val cityNameDb: String,
)

fun WeatherDataCurrentDb.asDomainModel() : WeatherDataCurrent{

    return WeatherDataCurrent(
            dateTimeUnix = dateTimeUnixDb,
            weatherDescriptionCurrent = weatherDescriptionCurrentDb,
        weatherIcon = weatherIconDb,
        temperatureCurrent = temperatureCurrentDb,
        feelsLike = feelsLikeDb,
        pressure = pressureDb,
        humidity = humidityDb,
        windSpeed = windSpeedDb,
        country = countryDb,
        sunset = sunsetDb,
        sunrise = sunriseDb,
        cityName = cityNameDb

        )

}