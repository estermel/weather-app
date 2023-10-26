package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class RainDataDto(
    @field:Json(name = "3h")
    val in3h: Double
)