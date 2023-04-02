package com.kimoterru.weatherless.data.repository

import com.kimoterru.weatherless.data.datasource.remote.WeatherForecastApi
import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.domain.repository.WeatherRepository
import com.kimoterru.weatherless.domain.util.Resource

private const val LAT = 42.87
private const val LON = 74.59

class WeatherRepositoryImpl (
    private val weatherForecastApi: WeatherForecastApi
): WeatherRepository {

    override suspend fun getWeatherCityFromServer(): Resource<WeatherResponse> {
        return try {
            val requestData = weatherForecastApi.getWeatherDataOfCity(LAT, LON)
            Resource.success(data = requestData)
        } catch (e: Exception) {
            Resource.error(msg = e.message.toString())
        }
    }

    override suspend fun getWeatherCityByWeekFromServer(): Resource<WeatherResponse> {
        return try {
            val requestData = weatherForecastApi.getWeatherDataByWeek(LAT, LON)
            Resource.success(data = requestData)
        } catch (e: Exception) {
            Resource.error(msg = e.message.toString())
        }
    }

}