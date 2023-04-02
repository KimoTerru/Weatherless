package com.kimoterru.weatherless.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class DailyResponse(
    @SerializedName("sunrise")
    val sunrise: List<String>,
    @SerializedName("sunset")
    val sunset: List<String>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weathercode: List<Int>
)