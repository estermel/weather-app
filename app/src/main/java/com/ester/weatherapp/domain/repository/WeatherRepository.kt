package com.ester.weatherapp.domain.repository

import com.ester.weatherapp.domain.util.Resource
import com.ester.weatherapp.domain.weather.Weather

interface WeatherRepository {

    suspend fun getWeatherData(city: String, count: Int, units: String): Resource<Weather>
    suspend fun getWeatherDataByLocation(lat: Double, lon: Double, count: Int, units: String): Resource<Weather>

}