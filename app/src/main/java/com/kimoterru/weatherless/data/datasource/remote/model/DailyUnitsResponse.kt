package com.kimoterru.weatherless.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class DailyUnitsResponse(
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weathercode")
    val weathercode: String
)