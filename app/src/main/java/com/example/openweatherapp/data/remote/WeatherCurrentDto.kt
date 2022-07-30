package com.example.openweatherapp.data.remote

data class ContainerCurrentWeather(
    val coord: CoordCurrent,
    val weather: List<WeatherCurrent>,
    val main: MainCurrent,
    val visibility: Int,
    val wind: WindCurrent,
    val clouds: CloudsCurrent,
    val dt: Long,
    val sys: SysCurrent,
    val timezone: Long,
    val id: Long,
    val name: String,
)
data class CoordCurrent(val lon: Double, val lat: Double)
// спискок с ОДНИМ объектом, доступ через [0]
data class WeatherCurrent(val id: Int, val main: String, val description: String, val icon: String)
data class MainCurrent(val temp: Double, val feels_like: Double, val temp_min: Double, val temp_max: Double, val pressure: Int, val humidity: Int )

data class WindCurrent(val speed: Double, val deg: Int)
data class CloudsCurrent(val all: Int)
data class SysCurrent(val country: String, val sunrise: Long, val sunset: Long)


/*

/*
                        * {
                          "coord": {
                            "lon": -122.08,
                            "lat": 37.39
                          },
                          "weather": [
                            {
                              "id": 800,
                              "main": "Clear",
                              "description": "clear sky",
                              "icon": "01d"
                            }
                          ],
                          "base": "stations",
                          "main": {
                            "temp": 282.55,
                            "feels_like": 281.86,
                            "temp_min": 280.37,
                            "temp_max": 284.26,
                            "pressure": 1023,
                            "humidity": 100
                          },
                          "visibility": 10000,
                          "wind": {
                            "speed": 1.5,
                            "deg": 350
                          },
                          "clouds": {
                            "all": 1
                          },
                          "dt": 1560350645,
                          "sys": {
                            "type": 1,
                            "id": 5122,
                            "message": 0.0139,
                            "country": "US",
                            "sunrise": 1560343627,
                            "sunset": 1560396563
                          },
                          "timezone": -25200,
                          "id": 420006353,
                          "name": "Mountain View",
                          "cod": 200
                          } */