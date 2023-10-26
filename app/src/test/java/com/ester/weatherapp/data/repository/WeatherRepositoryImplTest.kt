package com.ester.weatherapp.data.repository

import com.ester.weatherapp.data.WeatherApi
import com.ester.weatherapp.data.WeatherDto
import com.ester.weatherapp.data.mappers.toWeatherMap
import com.ester.weatherapp.domain.util.Resource
import com.ester.weatherapp.domain.weather.CityData
import com.ester.weatherapp.domain.weather.CoordinateData
import com.ester.weatherapp.domain.weather.Weather
import com.ester.weatherapp.domain.weather.WeatherData
import com.ester.weatherapp.domain.weather.WeatherForecastData
import com.ester.weatherapp.domain.weather.WeatherMainData
import com.ester.weatherapp.domain.weather.WindData
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.time.LocalDateTime

@RunWith(JUnit4::class)
class WeatherRepositoryImplTest {

    private val api = mockk<WeatherApi>()
    private val repository: WeatherRepositoryImpl = WeatherRepositoryImpl(api)

    @Before
    fun setup() {
    }

    @Test
    fun given_request_whenGetWeatherData_shouldReturnResponse() = runBlocking {
        // Mock the API request
        val city = "London"
        val count = 5
        val units = "metric"
        val appId = "app_id_here"
        val response = mockk<WeatherDto>()
        val expectedWeather = mockWeather

        coEvery { api.getWeatherData(city, count, units, appId) } returns response
        every { response.toWeatherMap() } returns expectedWeather

        val result = repository.getWeatherData(city, count, units)

        coVerify { api.getWeatherData(city, count, units, appId) }

        assertEquals(Resource.Success(expectedWeather), result)
    }

    @Test
    fun given_request_whenGetWeatherDataByLocation_shouldReturnResponse() = runBlocking {
        // Mock the API request
        val lat = -6.111
        val lon = 120.333
        val count = 5
        val units = "metric"
        val appId = "app_id_here"
        val response = mockk<WeatherDto>()
        val expectedWeather = mockWeather

        coEvery { api.getWeatherDataByLocation(lat, lon, count, units, appId) } returns response
        every { response.toWeatherMap() } returns expectedWeather

        val result = repository.getWeatherDataByLocation(lat, lon, count, units)

        coVerify { api.getWeatherDataByLocation(lat, lon, count, units, appId) }

        assertEquals(Resource.Success(expectedWeather), result)
    }

    companion object {
        val mockWeather: Weather = Weather(
            cod = "200",
            cityName = "Jakarta",
            count = 3,
            cityData = CityData(
                id = 100,
                name = "Jakarta",
                coordinate = CoordinateData(
                    lat = -6.222,
                    lon = 100.3
                ),
                country = "ID",
                population = 1000,
                timezone = 1,
                sunset = 1,
                sunrise = 1
            ),
            weatherForecastList = mutableListOf(
                WeatherForecastData(
                    dateTimeUnix = LocalDateTime.now(),
                    mainData = WeatherMainData(
                        temp = 30.1,
                        feelsLike = 24.2,
                        tempMin = 29.2,
                        tempMax = 35.5,
                        pressure = 30,
                        seaLevel = 1,
                        groundLevel = 1,
                        humidity = 2,
                        tempKf = 2.4
                    ),
                    weatherData = mutableListOf(
                        WeatherData(
                            id = 1,
                            main = "main",
                            description = "desc",
                            icon = "ic"
                        )
                    ),
                    cloudData = null,
                    windData = WindData(
                        speed = 3.1,
                        degree = 5,
                        gust = 3.2
                    ),
                    visibility = 10000,
                    pop = 2.2,
                    sysData = null,
                    dateTime = "2023-10-29 00:00:00"
                )
            )
        )
    }
}