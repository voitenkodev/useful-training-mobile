package main

import android.app.Application
import com.google.firebase.FirebaseOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import initCommonKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this, firebaseOptions())
        initKoin()
    }

    private fun firebaseOptions() = FirebaseOptions.Builder()
        .setApiKey("AIzaSyCYxSErpIlGhlU8mxkHlYDIwKlp9DINLE4")
        .setStorageBucket("usefultraining-e8811.appspot.com")
        .setProjectId("usefultraining-e8811")
        .setApplicationId("1:152127980653:android:612172b2ad983d64df2b64")
        .build()

    private fun initKoin() = initCommonKoin {
        androidLogger()
        androidContext(this@App)
    }
}