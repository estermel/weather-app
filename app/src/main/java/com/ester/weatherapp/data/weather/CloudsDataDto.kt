package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class CloudsDataDto(
    @field:Json(name = "all")
    val all: Int
)