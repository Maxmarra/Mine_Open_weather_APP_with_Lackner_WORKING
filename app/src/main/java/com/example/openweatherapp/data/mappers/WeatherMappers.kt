package com.example.openweatherapp.data.mappers

import com.example.openweatherapp.data.remote.Container
import com.example.openweatherapp.data.remote.ContainerCurrentWeather
import com.example.openweatherapp.domain.weather.WeatherData
import com.example.openweatherapp.domain.weather.WeatherDataCurrent
import com.example.openweatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Container.toWeatherData(): List<WeatherData>{

    return list.map{

        WeatherData(

            temperatureF = it.main.temp.toInt(),
            humidityF = it.main.humidity,
            descriptionF = it.weather[0].description,
            iconF = it.weather[0].icon,
            speedF = it.wind.speed.toInt(),
            dateTimeUnixF = it.dt

        )
    }
}

fun ContainerCurrentWeather.toWeatherDataCurrent(): WeatherDataCurrent{

    return WeatherDataCurrent(
        lon = coord.lon,
        lat = coord.lat,

        visibility = visibility,

        //type = WeatherType.fromWMO(weather[0].id),

        weatherDescGroup = weather[0].main,
        weatherDescriptionCurrent = weather[0].description,
        weatherIcon = weather[0].icon,

        temperatureCurrent = main.temp.toInt(),
        feelsLike = main.feels_like.toInt(),
        pressure = main.pressure,
        humidity = main.humidity,

        windSpeed = wind.speed.toInt(),

        dateTimeUnix = dt,

        country = sys.country,
        sunrise = sys.sunrise,
        sunset = sys.sunset,

        cityId = id,
        cityName = name,


    )

}