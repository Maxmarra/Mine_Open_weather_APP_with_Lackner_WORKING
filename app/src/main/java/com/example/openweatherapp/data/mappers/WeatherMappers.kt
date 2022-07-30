package com.example.openweatherapp.data.mappers

import com.example.openweatherapp.data.remote.Container
import com.example.openweatherapp.data.remote.ContainerCurrentWeather
import com.example.openweatherapp.domain.weather.WeatherData
import com.example.openweatherapp.domain.weather.WeatherDataCurrent
import com.example.openweatherapp.domain.weather.WeatherType

fun Container.toWeatherData(): List<WeatherData>{

    return list.map{

        WeatherData(
            //time = it.dt,
            temperature = it.main.temp,
            //feelsLike = it.main.feelsLike,
            weatherDescription = it.weather[0].description,
            //speed = it.wind.speed
            dateTime = it.dt,
            type = WeatherType.fromWMO(it.weather[0].id)
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

        temperatureCurrent = main.temp,
        feelsLike = main.feels_like,
        pressure = main.pressure,
        humidity = main.humidity,

        windSpeed = wind.speed,

        dateTimeUnix = dt,

        country = sys.country,
        sunrise = sys.sunrise,
        sunset = sys.sunset,

        cityId = id,
        cityName = name,


    )

}