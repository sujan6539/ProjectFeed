package com.sujan.code.newsfeed

import android.app.Application

class NewsFeedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    // TODO Sujan Encrypt this key
    companion object {
        const val API_KEY = "jpVeYAR9pxw5jhfhMFcTnumGpWVXIulO"
    }
}