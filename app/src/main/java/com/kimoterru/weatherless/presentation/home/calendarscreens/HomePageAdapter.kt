package com.kimoterru.weatherless.presentation.home.calendarscreens

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kimoterru.weatherless.presentation.home.calendarscreens.day.DayFragment
import com.kimoterru.weatherless.presentation.home.calendarscreens.month.MonthFragment
import com.kimoterru.weatherless.presentation.home.calendarscreens.week.WeekFragment

class HomePageAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    private val listFragments = listOf(
        DayFragment(),
        WeekFragment(),
        MonthFragment()
    )

    override fun createFragment(position: Int): Fragment {
        return listFragments[position]
    }

    override fun getItemCount(): Int = listFragments.size

}