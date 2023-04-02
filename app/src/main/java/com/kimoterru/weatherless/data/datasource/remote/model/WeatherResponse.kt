package com.kimoterru.weatherless.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeatherResponse,
    @SerializedName("daily")
    val daily: DailyResponse,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnitsResponse,
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("hourly")
    val hourly: HourlyResponse,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnitsResponse,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
)