package com.example.openweatherapp.data.database

import androidx.lifecycle.LiveData

class CurrentWeatherRoomRepoImpl(
    private val currentWeatherDao: CurrentWeatherDao
): CurrentWeatherRoomRepo {

    override fun getCurrentWeather(): LiveData<WeatherDataCurrentDb> {
        return currentWeatherDao.getCurrentWeather()
    }

    override fun insertCurrentWeather(currentWeather: WeatherDataCurrentDb) {
        currentWeatherDao.insertCurrentWeather(currentWeather)
    }
}