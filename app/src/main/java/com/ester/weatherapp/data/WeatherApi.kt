package com.ester.weatherapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/forecast")
    suspend fun getWeatherData(
        @Query("q") city: String,
        @Query("cnt") count: Int,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): WeatherDto

    @GET("data/2.5/forecast")
    suspend fun getWeatherDataByLocation(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") count: Int,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): WeatherDto
}