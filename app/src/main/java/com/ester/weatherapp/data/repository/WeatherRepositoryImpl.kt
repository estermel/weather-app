package com.ester.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.ester.weatherapp.data.WeatherApi
import com.ester.weatherapp.data.mappers.toWeatherMap
import com.ester.weatherapp.domain.repository.WeatherRepository
import com.ester.weatherapp.domain.util.Resource
import com.ester.weatherapp.domain.weather.Weather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(city: String, count: Int, units: String): Resource<Weather> {
        return try {
            val response = api.getWeatherData(
                city,
                count,
                units,
                APP_ID,
            )
            Resource.Success(data = response.toWeatherMap())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherDataByLocation(lat: Double, lon: Double, count: Int, units: String): Resource<Weather> {
        return try {
            val response = api.getWeatherDataByLocation(
                lat,
                lon,
                count,
                units,
                APP_ID,
            )
            Resource.Success(data = response.toWeatherMap())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    companion object {
        const val APP_ID = "f904cac592c262b6360eef677b106f31"
    }
}