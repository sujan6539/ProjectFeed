package com.sujan.code.newsfeed.dagger

import com.sujan.code.newsfeed.controller.activity.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    // Classes that can be injected by this Component
    fun inject(activity: HomeActivity)
}