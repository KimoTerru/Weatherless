package com.kimoterru.weatherless.presentation.home.calendarscreens.week

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kimoterru.weatherless.data.datasource.remote.model.WeatherResponse
import com.kimoterru.weatherless.databinding.FragmentWeekBinding
import com.kimoterru.weatherless.domain.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeekFragment : Fragment() {

    private val binding: FragmentWeekBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel: WeekViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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
                Status.SUCCESS -> it.data?.let { it1 -> displayContent(it1) }
                Status.ERROR -> displayErrorMessage(it.message.toString())
                Status.LOADING -> binding.loadingProgressbar.visibility = View.VISIBLE
            }
        }
    }

    private fun displayContent(data: WeatherResponse) = with(binding) {
        loadingProgressbar.visibility = View.GONE
        contentOfWeekInclude.apply {
            root.visibility = View.VISIBLE
            weekRv.apply {
                adapter = WeekAdapter(data = data)
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