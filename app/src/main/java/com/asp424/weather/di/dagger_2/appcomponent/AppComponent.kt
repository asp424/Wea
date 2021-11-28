package com.asp424.weather.di.dagger_2.appcomponent


import com.asp424.weather.activity.DetailGisActivity
import com.asp424.weather.activity.DetailYanActivity
import com.asp424.weather.activity.MainActivity
import com.asp424.weather.application.App

import com.asp424.weather.di.dagger_2.models.*
import com.asp424.weather.di.dagger_2.models.viewmodel.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        JsoupSourceModule::class,
        ViewModelFactoryModule::class,
        RestSourceModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: DetailGisActivity)
    fun inject(activity: DetailYanActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun create(): AppComponent
    }
}