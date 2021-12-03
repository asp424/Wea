package com.asp424.weather.app_widgets

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.RemoteViews
import com.bumptech.glide.Glide
import com.asp424.weather.R
import com.asp424.weather.data.internet.jsoup.getOnSitesTemps
import com.asp424.weather.utilites.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class Hydro: AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            CoroutineScope(Dispatchers.IO).launch {
                setStateScreen(context, appWidgetId, "hyd")
                updateHydAppWidget(context, appWidgetManager, appWidgetId)
            }
        }
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if (intent?.action == "update") {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            CoroutineScope(Dispatchers.IO).launch {
                updateGisViews(context, appWidgetManager) {
                    appWidgetManager.updateAppWidget(getStateScreen(context!!, "gis"), VIEWS_GIS)
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                updateYanViews(context, appWidgetManager) {
                    appWidgetManager.updateAppWidget(getStateScreen(context!!, "yan"), VIEWS_YAN)
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                updateHydViews(context, appWidgetManager) {
                    appWidgetManager.updateAppWidget(getStateScreen(context!!, "hyd"), VIEWS_HYD)
                }
            }
        }
    }
}


@SuppressLint("SimpleDateFormat")
private suspend fun updateHydAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    updateHydViews(context, appWidgetManager){
        appWidgetManager.updateAppWidget(appWidgetId, VIEWS_HYD)
    }
}


@SuppressLint("SimpleDateFormat")
 suspend fun updateHydViews(context: Context?, appWidgetManager: AppWidgetManager, function: () -> Unit) {
    VIEWS_HYD.apply {
        setViewVisibility(R.id.progress_hyd, View.VISIBLE)
        appWidgetManager.updateAppWidget(getStateScreen(context!!, "hyd"), this)
        setOnClickPendingIntent(
            R.id.image_yandex,
            getPendingSelfIntent(context, "update", Hydro::class.java)
        )
        val im = Glide.with(context!!)
            .asBitmap()
            .load(
                when (getOnSitesTemps(GID_URL, TAG, 15, 1)) {
                    "Ливневый дождь со снегом" -> "https://meteoinfo.ru/images/ico/24d_s.png"
                    "Количество облаков не изменилось" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                    "Снег слабый непрерывный" -> "https://meteoinfo.ru/images/ico/2d_s.png"
                    "Снег" -> "https://meteoinfo.ru/images/ico/2d_s.png"
                    "Небольшая облачность, без осадков" -> "https://meteoinfo.ru/images/ico/7d_s.png"
                    "Облачно с прояснениями, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                    "Снег умеренный непрерывный" -> "https://meteoinfo.ru/images/ico/2d_s.png"
                    "Облачно, кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                    "Облачно, временами небольшие осадки" -> "https://meteoinfo.ru/images/ico/15d_s.png"
                    "Облачно, без осадков" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                    "Облачно с прояснениями, временами небольшой снег" -> "https://meteoinfo.ru/images/ico/12d_s.png"
                    "Переменная облачность, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                    "Облачно, небольшой кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                    else -> {
                        "https://meteoinfo.ru/images/ico/5d_s.png"
                    }
                }
            )
            .submit()
        setTextViewText(
            R.id.appwidget_text,
            getOnSitesTemps(GID_URL, TAG, 10, 1) + " °C"
        )
        setTextViewText(
            R.id.hyd_time,
            SimpleDateFormat("HH:mm").format(Calendar.getInstance().time.time)
        )
        runCatching {
            setImageViewBitmap(R.id.image_now, im.get())
        }
        setViewVisibility(R.id.progress_hyd, View.GONE)
        function()
    }
}


