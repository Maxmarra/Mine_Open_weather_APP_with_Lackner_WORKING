package com.example.openweatherapp.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.openweatherapp.R
import com.example.openweatherapp.presentation.state.CurrentWeatherState
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WeatherCard(
    currentWeatherState: CurrentWeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    currentWeatherState.weatherDataCurrent?.let {

        Log.d("ICON", it.weatherIcon)
        val icon = "http://openweathermap.org/img/wn/${it.weatherIcon}@4x.png"

        Column() {
            Card(
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
                        text = "${it.country}, ${it.cityName}",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = SimpleDateFormat("EEEE, d MMMM,  yyyy", Locale.getDefault())
                            .format(
                                Date(it.dateTimeUnix * 1000)
                            ),
                        modifier = Modifier.align(Alignment.End),
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.h6
                    )

                    Spacer(modifier = Modifier.height(16.dp))
//                    AsyncImage(
//                        model = icon,
//                        contentDescription = null
//                    )

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),) {

                        Row(
                            modifier
                                .weight(1F)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {


                            Text(
                                text = SimpleDateFormat("H:mm", Locale.getDefault())
                                    .format(
                                        Date(it.sunrise * 1000)
                                    ),

                                color = MaterialTheme.colors.onPrimary,
                                style = MaterialTheme.typography.h6
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Image(
                                imageVector = ImageVector.vectorResource (id = R.drawable.ic_sunrise),
                                contentDescription = null,
                                modifier.size(50.dp)

                            )
                        }


                        Row(
                            modifier
                                .weight(1F)
                                .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                        ) {
                            Image(
                                imageVector = ImageVector.vectorResource (id = R.drawable.ic_sunset),
                                contentDescription = null,
                                modifier.size(50.dp)

                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = SimpleDateFormat("H:mm", Locale.getDefault())
                                    .format(
                                        Date(it.sunset * 1000)
                                    ),

                                color = MaterialTheme.colors.onPrimary,
                                style = MaterialTheme.typography.h6
                            )
                        }
                    }
                    SubcomposeAsyncImage(
                        model = icon,
                        loading = {
                            CircularProgressIndicator()
                        },
                        contentDescription = it.weatherDescGroup
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "${it.temperatureCurrent}??C",
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "???? ?????????????????? ${it.feelsLike}??C",
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = it.weatherDescriptionCurrent,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        WeatherCardBottomPart(
                            value = it.pressure,
                            unit = " ??????",
                            iconId = R.drawable.ic_pressure
                        )
                        WeatherCardBottomPart(
                            value = it.humidity,
                            unit = " %",
                            iconId = R.drawable.ic_drop,

                            )
                        WeatherCardBottomPart(
                            value = it.windSpeed,
                            unit = " ????/??",
                            iconId = R.drawable.ic_wind

                        )
                    }


                }


            }
        }
    }
}

//@Composable
//fun SunSetRise(
//    unixTime: Long,
//    horizontalArrangement: Arrangement.Horizontal,
//    @DrawableRes sunIconId: Int,
//    modifier: Modifier = Modifier) {
//
//    Row(modifier.fillMaxWidth(),
//        horizontalArrangement = horizontalArrangement) {
//        Text(
//            text = SimpleDateFormat("H:mm", Locale.getDefault())
//                .format(Date(unixTime * 1000)),
//            color = MaterialTheme.colors.onPrimary,
//            style = MaterialTheme.typography.h6
//        )
//        Spacer(modifier = Modifier.width(4.dp))
//        Image(
//            imageVector = ImageVector.vectorResource (id = sunIconId),
//            contentDescription = null,
//            modifier.size(50.dp)
//
//        )
//    }
//}


