package com.example.openweatherapp.data.remote

data class Container(val list: List<DataList>)
data class DataList(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    //val dt_txt: String
    )

data class Main(val temp: Double, val humidity: Int)
data class Weather(val description: String, val icon: String,)
data class Wind(val speed: Double)

val json = """ 

class Container -> {
                                 "cod": "200",
                                 "message": 0,
                                 "cnt": 40,
   class DataList ->             "list": [
                                    {
        поле класса DataList        "dt": 1647345600,
        class Main ->               "main": {
                                        "temp": 286.88,
                                        "feels_like": 285.93,
                                        "temp_min": 286.74,
                                        "temp_max": 286.88,
                                        "pressure": 1021,
                                        "sea_level": 1021,
                                        "grnd_level": 1018,
                                        "humidity": 62,
                                        "temp_kf": 0.14
                                    },
        class Weather ->           "weather": [
                                        {
                                        "id": 804,
                                        "main": "Clouds",
                                        "description": "overcast clouds",
                                        "icon": "04d"
                                        }
                                    ],
                                    "clouds": {
                                        "all": 85
                                    },
        class Wind ->               "wind": {
                                        "speed": 3.25,
                                        "deg": 134,
                                        "gust": 4.45
                                    },
        поле класса DataList ->     "visibility": 10000,
                                    "pop": 0,
                                    "sys": {
                                        "pod": "d"
                                    },
                                    "dt_txt": "2022-03-15 12:00:00"
},

// следующий день списка
{
"dt": 1647356400,
"main": {
    "temp": 286.71,
    "feels_like": 285.77.......

Каждый заголовок - это отдельный класс
по хорошему класс нужно назвать Hourly
но так как мы можем подставить реальное имя через
@field:Json(name = "hourly")
то мы дали свое название WeatherDto
Этот класс создан для хранения одного объекта
поля которого мы опишем в классе WeatherDataDto
    
  """