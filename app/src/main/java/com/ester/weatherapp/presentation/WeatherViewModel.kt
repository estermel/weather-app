package com.ester.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ester.weatherapp.domain.location.LocationTracker
import com.ester.weatherapp.domain.repository.WeatherRepository
import com.ester.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun loadWeatherInfo(city: String? = null) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            if (city == null) {
                locationTracker.getCurrentLocation()?.let { location ->
                    when (val result = repository.getWeatherDataByLocation(location.latitude, location.longitude, 24, "metric")) {
                        is Resource.Success -> {
                            state = state.copy(
                                weather = result.data,
                                isLoading = false,
                                error = null
                            )
                        }

                        is Resource.Error -> {
                            state = state.copy(
                                weather = result.data,
                                isLoading = false,
                                error = result.message
                            )
                        }
                    }
                } ?: kotlin.run {
                    state = state.copy(
                        isLoading = false,
                        error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                    )
                }
            } else {
                when (val result = repository.getWeatherData(city, 24, "metric")) {
                    is Resource.Success -> {
                        state = state.copy(
                            weather = result.data,
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            weather = result.data,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }

    fun onSearchTextChange(text: String) {
        _searchText.value = text
        loadWeatherInfo(text)
    }
}