package com.example.openweatherapp.di

import com.example.openweatherapp.data.location.DefaultLocationTracker
import com.example.openweatherapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    //whenever we use LocationTracker
    // it really uses defaultLocationTracker: DefaultLocationTracker
    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker)
    : LocationTracker
}