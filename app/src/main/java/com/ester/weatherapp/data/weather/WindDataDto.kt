package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class WindDataDto(
    @field:Json(name = "speed")
    val speed: Double,

    @field:Json(name = "deg")
    val degree: Int,

    @field:Json(name = "gust")
    val gust: Double
)