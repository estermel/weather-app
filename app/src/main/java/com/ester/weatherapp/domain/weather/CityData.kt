package com.ester.weatherapp.domain.weather

data class CityData(
    val id: Int,
    val name: String,
    val coordinate: CoordinateData,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)
