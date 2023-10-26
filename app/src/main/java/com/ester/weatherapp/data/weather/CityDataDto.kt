package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class CityDataDto(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "coord")
    val coordinate: CoordinateDataDto,

    @field:Json(name = "country")
    val country: String,

    @field:Json(name = "population")
    val population: Int,

    @field:Json(name = "timezone")
    val timezone: Int,

    @field:Json(name = "sunrise")
    val sunrise: Int,

    @field:Json(name = "sunset")
    val sunset: Int
)