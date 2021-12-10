package com.asp424.weather.data.internet.jsoup

import com.asp424.weather.data.view_states.InternetResponse
import com.asp424.weather.utilites.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.jsoup.Jsoup
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class JsoupSource {
    suspend fun getGisData(): InternetResponse =
        suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.IO).launch {
                val listIcon = getOnSitesTemps(GIS_URL_TOD, GIS_ICON_LIST, 0, 5)
                val sunUp = getOnSitesTemps(GIS_URL, GIS_SUN_UP)
                val sunDown = getOnSitesTemps(GIS_URL, GIS_SUN_DOWN)
                continuation.resume(
                    InternetResponse.OnSuccess(
                        JSONObject()
                            .put("gis_temp", getOnSitesTemps(GIS_URL_TOD, GIS_TEMP_TOD,
                                0, 4))
                            .put("gis_icon", if (listIcon!!.isEmpty())
                                getOnSitesTemps(GIS_URL_TOD, GIS_ICON_LIST1,
                                    0, 5) else listIcon)
                            .put("gis_sun_up", if (sunUp!!.isEmpty())
                                getOnSitesTemps(GIS_URL, GIS_SUN_UP1)
                            else sunUp)
                            .put("gis_sun_down", if (sunDown!!.isEmpty())
                                getOnSitesTemps(GIS_URL, GIS_SUN_DOWN1)
                            else sunDown
                    )
                )
                )
            }
        }

    suspend fun getYanData(): InternetResponse =
        suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.IO).launch {
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

    suspend fun getMsnData(): InternetResponse =
        suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.IO).launch {
                continuation.resume(
                    InternetResponse.OnSuccess(
                        JSONObject()
                            .put("msn_now", getOnSitesTemps(MSN_DET_URL, MSN_NOW_ROW, flag = 5))

                    )
                )
            }
        }
}

suspend fun getOnSitesTemps(
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
            6 -> Jsoup.connect(url).get()
                .getElementsByClass("temp-DS-EntryPoint1-1 tempSelected-DS-EntryPoint1-1")
            else -> {
            }
        }
    }.onSuccess {
        continuation.resume(it.toString())
    }.onFailure {
        continuation.resume("Err")
    }
}

