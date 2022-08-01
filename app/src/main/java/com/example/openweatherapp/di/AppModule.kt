package com.example.openweatherapp.di

import android.app.Application
import androidx.room.Room
import com.example.openweatherapp.data.database.CurrentWeatherRoomRepo
import com.example.openweatherapp.data.database.CurrentWeatherRoomRepoImpl
import com.example.openweatherapp.data.database.WeatherDataCurrentDb
import com.example.openweatherapp.data.database.WeatherDatabase
import com.example.openweatherapp.data.remote.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application)
    : FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    @Provides
    @Singleton
    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            "weather"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(db: WeatherDatabase): CurrentWeatherRoomRepo {
        return CurrentWeatherRoomRepoImpl(db.currentWeatherDao)
    }
}