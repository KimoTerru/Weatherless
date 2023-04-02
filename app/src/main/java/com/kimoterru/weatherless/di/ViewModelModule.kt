package com.kimoterru.weatherless.di

import com.kimoterru.weatherless.presentation.home.calendarscreens.day.DayViewModel
import com.kimoterru.weatherless.presentation.home.calendarscreens.week.WeekViewModel
import com.kimoterru.weatherless.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SearchViewModel()
    }

    viewModel {
        DayViewModel(
            repository = get()
        )
    }

    viewModel {
        WeekViewModel(
            repository = get()
        )
    }

}