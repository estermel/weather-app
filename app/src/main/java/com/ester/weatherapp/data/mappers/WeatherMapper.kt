package com.ester.weatherapp.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.ester.weatherapp.data.WeatherDto
import com.ester.weatherapp.data.weather.WeatherForecastDataDto
import com.ester.weatherapp.domain.weather.CityData
import com.ester.weatherapp.domain.weather.CloudData
import com.ester.weatherapp.domain.weather.CoordinateData
import com.ester.weatherapp.domain.weather.SysData
import com.ester.weatherapp.domain.weather.Weather
import com.ester.weatherapp.domain.weather.WeatherData
import com.ester.weatherapp.domain.weather.WeatherForecastData
import com.ester.weatherapp.domain.weather.WeatherMainData
import com.ester.weatherapp.domain.weather.WindData
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherMap(): Weather {
    return Weather(
        code,
        message,
        count,
        weatherDataList.map { it.toWeatherForecastDataMap() },
        CityData(
            id = city.id,
            sunrise = city.sunrise,
            sunset = city.sunset,
            name = city.name,
            timezone = city.timezone,
            coordinate = CoordinateData(
                city.coordinate.lat,
                city.coordinate.lon
            ),
            population = city.population,
            country = city.country
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherForecastDataDto.toWeatherForecastDataMap(): WeatherForecastData {
    return WeatherForecastData(
        dateTimeUnix = dateTime(dateTimeUnix),
        mainData = WeatherMainData(
            main.temp,
            main.feelsLike,
            main.tempMin,
            main.tempMax,
            main.pressure,
            main.seaLevel,
            main.groundLevel,
            main.humidity,
            main.tempKf
        ),
        weatherData = List(weather.size) { index ->
            WeatherData(
                weather[index].id,
                weather[index].main,
                weather[index].description,
                weather[index].icon
            )
        },
        cloudData = CloudData(
            clouds.all
        ),
        windData = WindData(
            wind.speed,
            wind.degree,
            wind.gust
        ),
        visibility = visibility,
        pop = pop,
        sysData = SysData(
            sys.partOfTheDay
        ),
        dateTime = dateTime
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateTime(dateTimeUnix: Long): LocalDateTime {
    val instant = Instant.ofEpochMilli(dateTimeUnix*1000)
    val zoneId = ZoneId.systemDefault()
    return instant.atZone(zoneId).toLocalDateTime()
}