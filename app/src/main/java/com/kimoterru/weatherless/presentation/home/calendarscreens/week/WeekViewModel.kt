package com.kimoterru.weatherless.presentation.home.calendarscreens.week

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.domain.repository.WeatherRepository
import com.kimoterru.weatherless.domain.util.Resource
import kotlinx.coroutines.launch

class WeekViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val weatherMutableLiveData = MutableLiveData<Resource<WeatherResponse>>(Resource.loading())
    val weatherLiveData: LiveData<Resource<WeatherResponse>> = weatherMutableLiveData

    fun getWeatherCity() = viewModelScope.launch {
        val data = repository.getWeatherCityByWeekFromServer()
        weatherMutableLiveData.postValue(data)
    }

}