package com.ester.weatherapp.presentation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weather?.weatherForecastList.let {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Weather forecast",
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))

            val groupedWeather =
                state.weather?.weatherForecastList?.groupBy { it.dateTimeUnix.dayOfMonth }?.values?.map { it.toMutableList() }

            LazyColumn(
                content = {
                groupedWeather?.size?.let {
                    items(it) { index ->
                        LazyRow(
                            state = rememberLazyListState(),
                            content = {
                            items(it) { id ->
                                Per3HWeatherDisplay(
                                    index,
                                    groupedWeather[id],
                                    modifier = Modifier
                                        .height(100.dp)
                                        .padding(6.dp)
                                        .padding(2.dp)
                                )
                            }
                        })
                    }
                }
            }
            )
        }
    }
}

