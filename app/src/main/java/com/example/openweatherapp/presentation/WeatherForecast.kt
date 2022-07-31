package com.example.openweatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier

) {
    state.weatherData?.let { data ->
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyRow(content = {
                items(data){
                    DailyWeatherDisplay(
                        weatherData = it,
                        modifier = Modifier
                        .height(150.dp)
                        .padding(horizontal = 16.dp))

                }
            })
        }
    }
}























