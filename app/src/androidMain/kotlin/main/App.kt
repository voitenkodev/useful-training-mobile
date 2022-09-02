package main

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class App : Application() {
    override fun onCreate() {
        Firebase.initialize(this)
        super.onCreate()
    }
}