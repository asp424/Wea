package com.asp424.weather.data.repository

import com.asp424.weather.data.internet.jsoup.JsoupSource
import com.asp424.weather.data.internet.retrofit.RestSource
import com.asp424.weather.data.view_states.InternetResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject
constructor(
    private val jsoupSource: JsoupSource,
    private val restSource: RestSource
) {
    suspend fun getJsoupData(): Flow<InternetResponse> = flow {
        emit(jsoupSource.getCityValues())
    }
    suspend fun getGisData(): Flow<InternetResponse> = flow {
        emit(jsoupSource.getGisData())
    }

    suspend fun getYanData(): Flow<InternetResponse> = flow {
        emit(jsoupSource.getYanData())
    }
}