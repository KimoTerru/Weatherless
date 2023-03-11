package com.kimoterru.weatherless.presentation.home.calendarscreens.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kimoterru.weatherless.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {

    private val binding: FragmentWeekBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

}