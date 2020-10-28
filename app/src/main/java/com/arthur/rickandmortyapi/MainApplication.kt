package com.arthur.rickandmortyapi

import android.app.Application
import com.arthur.rickandmortyapi.di.appModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin(this, listOf(appModule))
    }
}