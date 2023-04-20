package com.example.learn

import android.app.Application
/*
Domyślna klasa applikacji
 */
class App :Application () {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
    companion object{
        lateinit var appContext:App
    }
}