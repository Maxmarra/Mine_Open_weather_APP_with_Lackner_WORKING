package com.example.openweatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openweatherapp.presentation.state.WeatherState

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier

) {
    state.weatherData?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp)
        ) {
            Text(
                text = "Прогноз на 5 дней",
                fontSize = 20.sp,
                color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data){
                    WeatherForecastItem(
                        weatherData = it,
                        modifier = Modifier
                        .height(150.dp)
                        .padding(horizontal = 3.dp))

                }
            })
        }
    }
}























