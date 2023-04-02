package com.kimoterru.weatherless.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class HourlyResponse(
    @SerializedName("relativehumidity_2m")
    val relativehumidity2m: List<Int>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>
)