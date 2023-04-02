package com.kimoterru.weatherless.di

import com.kimoterru.weatherless.data.repository.WeatherRepositoryImpl
import com.kimoterru.weatherless.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(weatherForecastApi = get()) }
}