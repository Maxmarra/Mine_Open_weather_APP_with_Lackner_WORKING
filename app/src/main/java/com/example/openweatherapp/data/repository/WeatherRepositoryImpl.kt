package com.example.openweatherapp.data.repository

import com.example.openweatherapp.data.database.WeatherDataCurrentDb
import com.example.openweatherapp.data.database.WeatherDatabase
import com.example.openweatherapp.data.mappers.toWeatherData
import com.example.openweatherapp.data.mappers.toWeatherDataCurrent
import com.example.openweatherapp.data.remote.WeatherApi
import com.example.openweatherapp.domain.repository.WeatherRepository
import com.example.openweatherapp.domain.util.Resource
import com.example.openweatherapp.domain.weather.WeatherData
import com.example.openweatherapp.domain.weather.WeatherDataCurrent
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val database: WeatherDatabase
): WeatherRepository {

    override suspend fun getWeatherForecast(
        lat: Double,
        long: Double,
        appId: String
    ): Resource<List<WeatherData>> {

        return try {
            Resource.Success(
                data = api.getWeatherForecast(
                    lat = lat,
                    long = long,
                    appId = appId
                ).toWeatherData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getCurrentWeather(lat: Double,long: Double,appId: String)
    : Resource<WeatherDataCurrent> {

        return try {
            Resource.Success(
                data = api.getCurrentWeather(
                    lat = lat,
                    long = long,
                    appId = appId
                ).toWeatherDataCurrent()

            )
          database.currentWeatherDao.insertCurrentWeather(data)
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}