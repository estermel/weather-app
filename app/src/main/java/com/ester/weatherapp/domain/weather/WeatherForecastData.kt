package com.ester.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherForecastData(
    val dateTimeUnix: LocalDateTime,
    val mainData: WeatherMainData?,
    val weatherData: List<WeatherData>?,
    val cloudData: CloudData?,
    val windData: WindData?,
    val visibility: Int,
    val pop: Double,
    val sysData: SysData?,
    val dateTime: String?
)
