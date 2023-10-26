package com.ester.weatherapp.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ester.weatherapp.domain.weather.WeatherForecastData
import com.ester.weatherapp.presentation.ui.BlackText
import com.ester.weatherapp.presentation.ui.White

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Per3HWeatherDisplay(
    index: Int,
    weather: List<WeatherForecastData>?,
    modifier: Modifier = Modifier
) {
    weather?.let {
        if (index < weather.size) {
            val date = weather[index].dateTimeUnix
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(4.dp),
                modifier = modifier.padding(2.dp)
            ) {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "${date.dayOfMonth} ${date.month} (${date.hour}:${date.minute})",
                        color = BlackText,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "T: ${it[index].mainData?.temp}°C",
                        color = BlackText,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "H: ${it[index].mainData?.humidity} %",
                        color = BlackText,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "W: ${it[index].windData?.speed} km/h",
                        color = BlackText,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}