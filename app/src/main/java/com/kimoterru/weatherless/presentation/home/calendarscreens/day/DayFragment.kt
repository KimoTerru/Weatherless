package com.kimoterru.weatherless.presentation.home.calendarscreens.day

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kimoterru.weatherless.R
import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.databinding.FragmentDayBinding
import com.kimoterru.weatherless.domain.util.Status.*
import com.kimoterru.weatherless.util.FIRST_ITEM
import com.kimoterru.weatherless.util.TIME_INDEX
import org.koin.androidx.viewmodel.ext.android.viewModel

class DayFragment : Fragment() {

    private val binding: FragmentDayBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel: DayViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWeatherCity()
        initObserve()
    }

    private fun initObserve() {
        viewModel.weatherLiveData.observe(viewLifecycleOwner) {
            when(it.status) {
                SUCCESS -> it.data?.let { it1 -> displayContent(it1) }
                ERROR -> displayErrorMessage(it.message.toString())
                LOADING -> binding.loadingProgressbar.visibility = View.VISIBLE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayContent(data: WeatherResponse) = with(binding) {
        loadingProgressbar.visibility = View.GONE
        contentOfDayInclude.apply {
            root.visibility = View.VISIBLE
            nameCity.text = data.timezone
            timeCity.text = data.currentWeather.time.substring(TIME_INDEX)
            tempCity.text = data.currentWeather.temperature.toString() + getString(R.string.celcius)
            weatherCity.text = data.currentWeather.weathercode.toString()
            //humidity.text = data.hourlyUnits.relativehumidity2m
            windSpeed.text = data.currentWeather.windspeed.toString() + getString(R.string.speed)
            sunriseTime.text = data.daily.sunrise[FIRST_ITEM].substring(TIME_INDEX)
            sunsetTime.text = data.daily.sunset[FIRST_ITEM].substring(TIME_INDEX)
            Log.d(this@DayFragment.tag, data.toString())
            todayRv.apply {
                adapter = DayAdapter(data = data)
            }
            tomorrowRv.apply {
                adapter = DayAdapter(data = data)
            }
            oneDayTomorrowRv.apply {
                adapter = DayAdapter(data = data)
            }
        }
    }

    private fun displayErrorMessage(message: String) = with(binding) {
        loadingProgressbar.visibility = View.GONE
        contentOfErrorInclude.apply {
            root.visibility = View.VISIBLE
            errorMessage.text = message
            repeatRequest.setOnClickListener {
                viewModel.getWeatherCity()
            }
        }
    }

}