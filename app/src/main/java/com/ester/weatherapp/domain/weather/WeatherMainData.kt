package com.ester.weatherapp.domain.weather

data class WeatherMainData(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val groundLevel: Int,
    val humidity: Int,
    val tempKf: Double
)