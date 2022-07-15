package com.greemoid.giphy.presentation

import android.app.Application
import com.greemoid.giphy.presentation.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appComponent)
        }
    }
}
