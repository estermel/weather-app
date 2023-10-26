package com.ester.weatherapp.data.weather

import com.squareup.moshi.Json

data class SysDataDto(
    @field:Json(name = "pod")
    val partOfTheDay: String
)