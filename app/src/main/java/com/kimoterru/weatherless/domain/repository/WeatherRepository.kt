package com.kimoterru.weatherless.domain.repository

import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.domain.util.Resource


interface WeatherRepository {

    suspend fun getWeatherCityFromServer(): Resource<WeatherResponse>

    suspend fun getWeatherCityByWeekFromServer(): Resource<WeatherResponse>

}