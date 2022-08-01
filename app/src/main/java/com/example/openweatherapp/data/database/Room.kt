package com.example.openweatherapp.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Database(entities = [WeatherDataCurrentDb::class], version = 1)
abstract class WeatherDatabase:RoomDatabase() {

    abstract val currentWeatherDao: CurrentWeatherDao
}


