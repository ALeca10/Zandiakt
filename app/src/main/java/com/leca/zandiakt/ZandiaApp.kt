package com.leca.zandiakt

import android.app.Application
import com.google.firebase.FirebaseApp

class ZandiaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}