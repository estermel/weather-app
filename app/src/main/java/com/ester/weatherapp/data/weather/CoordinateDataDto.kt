package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class CoordinateDataDto(
    @field:Json(name = "lon")
    val lon: Double,

    @field:Json(name = "lat")
    val lat: Double
)