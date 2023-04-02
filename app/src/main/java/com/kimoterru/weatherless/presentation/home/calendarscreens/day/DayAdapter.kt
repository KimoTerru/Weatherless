package com.kimoterru.weatherless.presentation.home.calendarscreens.day

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.databinding.ItemDayBinding

class DayAdapter(
    private val data: WeatherResponse
): RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    inner class DayViewHolder(
        private val binding: ItemDayBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: WeatherResponse, position: Int) {
            with(binding) {
                timeWeather.text = data.hourly.time[position].substring(11)
                temperatureWeather.text = data.hourly.temperature2m[position].toString() + "°C"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) = holder.bind(data, position)

    override fun getItemCount(): Int = data.hourly.time.size
}
