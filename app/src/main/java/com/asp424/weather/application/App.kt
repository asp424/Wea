package com.asp424.weather.application

import android.app.Application
import android.content.Context
import com.asp424.weather.di.dagger_2.appcomponent.AppComponent
import com.asp424.weather.di.dagger_2.appcomponent.DaggerAppComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

class App: Application() {
    @ExperimentalCoroutinesApi
    private var _appComponent: AppComponent? = null
    @ExperimentalCoroutinesApi
    val appComponent: AppComponent
        get() = checkNotNull(_appComponent)

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder()
            .application(this)
            .create()
    }
}

@ExperimentalCoroutinesApi
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> (applicationContext as App).appComponent
    }