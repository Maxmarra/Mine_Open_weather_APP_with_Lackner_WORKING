package com.example.openweatherapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface CurrentWeatherRoomRepo {
    fun getCurrentWeather(): LiveData<WeatherDataCurrentDb>
    fun insertCurrentWeather(currentWeather: WeatherDataCurrentDb)
}