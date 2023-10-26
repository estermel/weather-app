package com.ester.weatherapp.data

import com.ester.weatherapp.data.weather.CityDataDto
import com.ester.weatherapp.data.weather.WeatherForecastDataDto
import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "cod")
    val code: String,

    @field:Json(name = "message")
    val message: String,

    @field:Json(name = "cnt")
    val count: Int,

    @field:Json(name = "list")
    val weatherDataList: List<WeatherForecastDataDto>,

    @field:Json(name = "city")
    val city: CityDataDto
)