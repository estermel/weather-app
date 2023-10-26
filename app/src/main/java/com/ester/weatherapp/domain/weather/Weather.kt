package com.ester.weatherapp.domain.weather

data class Weather(
    val cod: String,
    val cityName: String,
    val count: Int,
    val weatherForecastList: List<WeatherForecastData>,
    val cityData: CityData
)