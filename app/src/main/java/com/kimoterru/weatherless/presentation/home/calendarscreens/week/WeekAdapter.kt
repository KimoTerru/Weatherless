package com.kimoterru.weatherless.presentation.home.calendarscreens.week

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.databinding.ItemWeekBinding

class WeekAdapter(
    private val data: WeatherResponse
): RecyclerView.Adapter<WeekAdapter.WeekViewHolder>() {

    inner class WeekViewHolder(
        private val binding: ItemWeekBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: WeatherResponse, position: Int) {
            with(binding) {
                //weatherHumidity.text = data.hourlyUnits.relativehumidity2m
                weatherWindSpeed.text = data.hourly.windspeed10m[position].toString() + "km/h"
                weatherTime.text = data.hourly.time[position].substring(11)
                //weatherName.text = data.currentWeather.weathercode.toString()
                weatherCelsius.text = data.hourly.temperature2m[position].toString() + "°C"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        return WeekViewHolder(
            ItemWeekBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) = holder.bind(data, position)

    override fun getItemCount(): Int = data.hourly.time.size
}