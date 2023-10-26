package com.ester.weatherapp.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun WeatherDataDisplay(
    value: Int,
    unit: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$value$unit",
            style = textStyle
        )
    }
}