package com.asp424.weather.di.dagger_2.models

import com.asp424.weather.data.internet.jsoup.JsoupSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class JsoupSourceModule {
    @Provides
    @Singleton
    fun  jsoupDatasource(): JsoupSource {
        return JsoupSource()
    }
}