package com.voitenko.usefultraining

import android.app.Application
import initCommonKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initCommonKoin()
    }
}