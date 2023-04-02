package com.kimoterru.weatherless

import android.app.Application
import com.kimoterru.weatherless.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherlessApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@WeatherlessApplication)
            modules(appModule)
        }
    }
}