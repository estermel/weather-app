package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class WeatherForecastDataDto(
    @field:Json(name = "dt")
    val dateTimeUnix: Long,

    @field:Json(name = "main")
    val main: MainDataDto,

    @field:Json(name = "weather")
    val weather: List<WeatherDataDto>,

    @field:Json(name = "clouds")
    val clouds: CloudsDataDto,

    @field:Json(name = "wind")
    val wind: WindDataDto,

    @field:Json(name = "visibility")
    val visibility: Int,

    @field:Json(name = "pop")
    val pop: Double,

    @field:Json(name = "rain")
    val rain: RainDataDto,

    @field:Json(name = "sys")
    val sys: SysDataDto,

    @field:Json(name = "dt_txt")
    val dateTime: String
)