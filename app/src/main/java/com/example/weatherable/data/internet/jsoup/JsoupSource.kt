package com.example.weatherable.data.internet.jsoup

import com.example.weatherable.data.view_states.InternetResponse
import com.example.weatherable.utilites.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.jsoup.Jsoup
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class JsoupSource {
    suspend fun getCityValues(): InternetResponse =
        suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.Default).launch {
                continuation.resume(
                    InternetResponse.OnSuccess(
                        JSONObject()
                            .put("hydro_temp", getOnSitesTemps(GID_URL, TAG, 10, 1))
                            .put("hydro_now_rain", getOnSitesTemps(GID_URL, TAG, 15, 1))
                            .put("gis_temp", getOnSitesTemps(GIS_URL_TOD, GIS_TEMP_TOD) + " °C")
                            .put("gis_rain_now", getOnSitesTemps(GIS_URL, "div", flag = 3)?.sA?.sB)
                            .put("yan_temp", getOnSitesTemps(YAN_URL, YAN_TEMP, 1) + " °C")
                            .put("yan_rain_now", getOnSitesTemps(YAN_URL, YAN_RAIN, 0))
                    )
                )
            }
        }

    suspend fun getGisData(): InternetResponse =
        suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.Default).launch {
                continuation.resume(
                    InternetResponse.OnSuccess(
                        JSONObject()
                            .put("gis_temp_tod", getOnSitesTemps(GIS_URL_TOD, GIS_TEMP_TOD, 0, 4))
                            .put("gis_icon_tod", getOnSitesTemps(GIS_URL_TOD, GIS_ICON_LIST, 0, 5))
                            .put("gis_temp_tom", getOnSitesTemps(GIS_URL_TOM, GIS_TEMP_TOD, 0, 4))
                            .put("gis_icon_tom", getOnSitesTemps(GIS_URL_TOM, GIS_ICON_LIST, 0, 5))
                            .put("gis_sun_up", getOnSitesTemps(GIS_URL, GIS_SUN_UP, 0))
                            .put("gis_sun_down", getOnSitesTemps(GIS_URL, GIS_SUN_UP, 1))
                    )
                )
            }
        }

    suspend fun getYanData(): InternetResponse =
        suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.Default).launch {
                continuation.resume(
                    InternetResponse.OnSuccess(
                        JSONObject().apply {
                            for (i in 0..3) {
                                put("yan_temp_tod$i", valueT(i))
                                put("yan_temp_rain$i", valueR(i))
                            }
                            for (i in 4..7) {
                                put("yan_temp_tom$i", valueT(i))
                                put("yan_temp_rain_t$i", valueR(i))
                            }
                        })
                )
            }
        }

    private suspend fun valueT(i: Int) = getOnSitesTemps(YAN_URL_DETAILS, YAN_TOD_DETAIL_TEMP, i)
    private suspend fun valueR(i: Int) = getOnSitesTemps(YAN_URL_DETAILS, YAN_TOD_DETAIL_RAIN, i)
    private suspend fun getOnSitesTemps(
        url: String,
        classOrTag: String,
        index: Int = 0,
        flag: Int = 0
    ): String? = suspendCoroutine { continuation ->
        runCatching {
            when (flag) {
                0 -> Jsoup.connect(url).get()
                    .getElementsByClass(classOrTag)[index]?.text()
                1 -> Jsoup.connect(url).get()
                    .getElementsByTag(classOrTag)[index]?.text()
                2 -> Jsoup.connect(url).get()
                    .getElementsByTag(classOrTag)[index]
                3 -> Jsoup.connect(url).get()
                    .getElementsByTag(classOrTag)
                4 -> Jsoup.connect(url).get()
                    .getElementsByClass(classOrTag).text()
                5 -> Jsoup.connect(url).get()
                    .getElementsByClass(classOrTag)
                else -> {
                }
            }
        }.onSuccess {
            continuation.resume(it.toString())
        }.onFailure {
            continuation.resume("Err")
        }
    }
}

