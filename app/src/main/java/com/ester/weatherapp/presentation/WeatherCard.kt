package com.ester.weatherapp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weather?.weatherForecastList?.get(0)?.let { data ->
        Card(
            colors = CardDefaults.cardColors(containerColor = backgroundColor),
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Now at ${state.weather.cityData.name}, ${state.weather.cityData.country}",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.mainData?.temp}°C",
                    fontSize = 50.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.visibility.div(1000)} km",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Visibility",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    data.mainData?.temp?.let {
                        WeatherDataDisplay(
                            value = it.roundToInt(),
                            unit = "°C",
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        )
                    }
                    data.mainData?.humidity?.let {
                        WeatherDataDisplay(
                            value = it,
                            unit = " %",
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        )
                    }
                    data.windData?.speed?.let {
                        WeatherDataDisplay(
                            value = it.roundToInt(),
                            unit = " km/h",
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Temperature (T)",
                        fontSize = 12.sp,
                        color = Color.White,
                    )
                    Text(
                        text = "Humidity (H)",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Wind speed (W)",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}