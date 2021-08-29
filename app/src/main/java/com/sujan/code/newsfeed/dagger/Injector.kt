package com.sujan.code.newsfeed.dagger

import android.app.Activity
import android.content.Context

class Injector private constructor(){

    companion object{
        private lateinit var instance: Injector

        /**
         * Returns the singleton of the Injector and initializes the modules and components
         * if this is the first time the Injector has been instantiated.
         *
         * @return (Injector)
         */
        fun getInstance(context: Context): Injector {
            var context = context
            if (context is Activity) {
                context = context.getApplicationContext()
            }
            if (!this::instance.isInitialized) {
                instance = Injector()
                instance.initialize(context)
            }
            return instance
        }
    }

    private var appComponent: AppComponent? = null

    private fun initialize(context: Context) {
        appComponent = createUniversalAppComponent(context)
    }

    fun getAppComponent(): AppComponent? {
        return appComponent
    }

    private fun createUniversalAppComponent(context: Context): AppComponent? {
        return DaggerAppComponent.builder()
            .appModule(AppModule(context))
            .build()
    }
}