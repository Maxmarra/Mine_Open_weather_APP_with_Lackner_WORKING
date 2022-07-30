package com.example.openweatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WeatherCard(
    currentWeatherState: CurrentWeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    currentWeatherState.weatherDataCurrent?.let {
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Сегодня ${
                        SimpleDateFormat("E MMM d y", Locale.getDefault())
                            .format( Date(it.dateTimeUnix * 1000)
                        )                      
                    }",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )

                //Text(text = it.weatherDescriptionCurrent)
               //Spacer(modifier = Modifier.height(16.dp))

//                SubcomposeAsyncImage(
//                    model = "http://openweathermap.org/img/wn/${it.weatherIcon}@2x.png",
//                    loading = {
//                        CircularProgressIndicator()
//                    },
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                )

//
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data("http://openweathermap.org/img/wn/${it.weatherIcon}@2x.png")
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = null,
//                    modifier = Modifier.width(200.dp).height(100.dp)
//                )
            }
        }
    }
}


//@Composable
//fun CurrentWeatherCard(currentWeatherState: WeatherStateCurrent) {
//    currentWeatherState.weatherDataCurrent?.let{
//        CurrentCard(currentWeatherData = it)
//    }
//}
//
//@Composable
//fun CurrentCard(currentWeatherData: WeatherDataCurrent,
//                modifier: Modifier = Modifier) {
//    Card(
//        backgroundColor = Color.Magenta,
//        shape = RoundedCornerShape(10.dp),
//        modifier = modifier.padding(16.dp)
//    ){
//        Column() {
//            Text(text = currentWeatherData.temperatureCurrent.toString())
//            Text(text = currentWeatherData.weatherDescriptionCurrent)
//
//        }
//    }
//}


//@Composable
//fun WeatherCard(
//    state: WeatherState
//) {
//    state.weatherData?.let { data ->
//        LazyColumn(content = {
//            items(data){
//                ForeCastCard(weatherData = it,)
//            }
//        })
//
//    }
//}
//@Composable
//fun ForeCastCard(weatherData: WeatherData,
//                 modifier: Modifier = Modifier
//){
//    Card(
//        backgroundColor = Color.Red,
//        shape = RoundedCornerShape(10.dp),
//        modifier = modifier.padding(16.dp)
//    ){
//        Text(text = weatherData.weatherDescription)
//    }
//}


/*
*   Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        )
                    }",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.temperatureCelsius}°C",
                    fontSize = 50.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                }
            }
        }*/