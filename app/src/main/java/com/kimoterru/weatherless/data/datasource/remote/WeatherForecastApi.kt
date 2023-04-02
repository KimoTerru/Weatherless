package com.kimoterru.weatherless.data.datasource.remote

import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastApi {

    @GET("v1/forecast?&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m&daily=weathercode,sunrise,sunset&current_weather=true&forecast_days=3&timezone=auto")
    suspend fun getWeatherDataOfCity(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherResponse

    @GET("v1/forecast?&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m&daily=weathercode,sunrise,sunset&current_weather=true&forecast_days=7&timezone=auto")
    suspend fun getWeatherDataByWeek(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherResponse

}