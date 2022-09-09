package main

import android.app.Application
import com.google.firebase.FirebaseOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class App : Application() {
    override fun onCreate() {
        Firebase.initialize(this, firebaseOptions())
        super.onCreate()
    }

    private fun firebaseOptions() = FirebaseOptions.Builder()
        .setApiKey("AIzaSyCYxSErpIlGhlU8mxkHlYDIwKlp9DINLE4")
        .setStorageBucket("usefultraining-e8811.appspot.com")
        .setProjectId("usefultraining-e8811")
        .setApplicationId("1:152127980653:android:612172b2ad983d64df2b64")
        .build()
}