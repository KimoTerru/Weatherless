package com.kimoterru.weatherless.di

import com.kimoterru.weatherless.data.datasource.remote.WeatherForecastApi
import com.kimoterru.weatherless.util.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single (createdAtStart = true) {
        provideRetrofit()
    }
    single { provideForecastApi(retrofit = get()) }
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
}

private fun provideForecastApi(retrofit: Retrofit): WeatherForecastApi = retrofit.create(WeatherForecastApi::class.java)