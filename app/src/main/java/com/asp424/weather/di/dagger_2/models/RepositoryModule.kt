package com.asp424.weather.di.dagger_2.models

import com.asp424.weather.data.internet.jsoup.JsoupSource
import com.asp424.weather.data.internet.retrofit.RestSource
import com.asp424.weather.data.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
    class RepositoryModule {
        @Provides
        @Singleton
        fun repository(
            jsoupDatasource: JsoupSource,
            restSource: RestSource
            ): Repository {
            return Repository(jsoupDatasource, restSource)
        }
    }

