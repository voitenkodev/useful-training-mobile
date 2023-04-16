package com.voitenko.usefultraining

import android.app.Application
import initCommonKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initCommonKoin {
            androidContext(this@App)
            androidLogger()
        }
    }
}