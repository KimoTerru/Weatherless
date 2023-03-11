package com.kimoterru.weatherless.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.kimoterru.weatherless.R
import com.kimoterru.weatherless.databinding.FragmentHomeBinding
import com.kimoterru.weatherless.presentation.home.calendarscreens.HomePageAdapter

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomeScreen()
    }

    private fun setupHomeScreen() = with(binding) {

        homePager.adapter = HomePageAdapter(this@HomeFragment)

        TabLayoutMediator(
            pageName, homePager
        ) { tab, position ->
            tab.text = when(position) {
                0 -> getText(R.string.day)
                1 -> getText(R.string.week)
                2 -> getText(R.string.month)
                else -> null
            }
        }.attach()
    }

}