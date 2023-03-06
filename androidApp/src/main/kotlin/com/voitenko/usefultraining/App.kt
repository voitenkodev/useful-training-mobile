package com.voitenko.usefultraining

import android.app.Application
import di.initAndroidKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        Firebase.initialize(this, firebaseOptions())
        initAndroidKoin(this)
    }

//    private fun firebaseOptions() = FirebaseOptions.Builder()
//        .setApiKey("AIzaSyCYxSErpIlGhlU8mxkHlYDIwKlp9DINLE4")
//        .setStorageBucket("usefultraining-e8811.appspot.com")
//        .setProjectId("usefultraining-e8811")
//        .setApplicationId("1:152127980653:android:612172b2ad983d64df2b64")
//        .build()
}