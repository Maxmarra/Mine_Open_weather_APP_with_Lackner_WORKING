package com.example.openweatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

const val APP_ID="0b119ac14932aba85806fc0b870975fc"

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("appid") appId: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ru",
    ): Container

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("appid") appId: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ru",
    ): ContainerCurrentWeather
}

//api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=0b119ac14932aba85806fc0b870975fc

