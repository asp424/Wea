package com.asp424.weather.di.dagger_2.models

import com.asp424.weather.data.internet.retrofit.RestSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RestSourceModule {
    @Provides
    @Singleton
    fun restSource(): RestSource {
        return RestSource()
    }
}