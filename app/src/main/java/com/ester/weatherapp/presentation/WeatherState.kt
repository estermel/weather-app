package com.ester.weatherapp.presentation

import com.ester.weatherapp.domain.weather.Weather

data class WeatherState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)