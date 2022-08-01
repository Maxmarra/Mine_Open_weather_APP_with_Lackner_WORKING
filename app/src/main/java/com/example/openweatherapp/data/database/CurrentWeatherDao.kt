package com.example.openweatherapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrentWeatherDao{

    @Query("select * from current")
    fun getCurrentWeather(): LiveData<WeatherDataCurrentDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather( currentWeather: WeatherDataCurrentDb)
}