package main

import android.app.Application
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import firebaseOptions

class App : Application() {
    override fun onCreate() {
        Firebase.initialize(this, firebaseOptions())
        super.onCreate()
    }
}