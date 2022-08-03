package com.example.openweatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.openweatherapp.domain.weather.WeatherData
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun WeatherForecastItem(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
) {

    val formattedTime = remember(weatherData){
        SimpleDateFormat("EE, d MMM", Locale.getDefault())
            .format(
                Date(weatherData.dateTimeUnixF * 1000)
            )
    }

    val formattedHour = remember(weatherData){
        SimpleDateFormat("H:mm", Locale.getDefault())
            .format(
                Date(weatherData.dateTimeUnixF * 1000)
            )
    }

    val icon = "http://openweathermap.org/img/wn/${weatherData.iconF}@4x.png"

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            //text = weatherData.dateText.toLocalDate().toString(),
            text = formattedTime,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = formattedHour,
            color = MaterialTheme.colors.onPrimary

        )
        SubcomposeAsyncImage(
            model = icon,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = weatherData.descriptionF,
            modifier = Modifier.width(40.dp)
        )

        Text(
            text = "${weatherData.temperatureF}°C",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6
        )
    }

}