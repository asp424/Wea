package com.asp424.weather.app_widgets

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import com.asp424.weather.R
import com.asp424.weather.activity.DetailGisActivity
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
class Gismeteo : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            CoroutineScope(Dispatchers.IO).launch {
                setStateScreen(context, appWidgetId, "gis")
                updateGisAppWidget(
                    context,
                    appWidgetManager
                )
            }
        }
    }
    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
        CoroutineScope(Dispatchers.IO).launch {
            updateGisViews(context, AppWidgetManager.getInstance(context)) {
                AppWidgetManager.getInstance(context).updateAppWidget(getStateScreen(context!!, "gis"), VIEWS_GIS)
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
                    appWidgetManager.updateAppWidget(ComponentName(context!!,
                        Yandex::class.java), VIEWS_YAN)
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
internal suspend fun updateGisAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager
) {
    updateGisViews(context, appWidgetManager) {
        appWidgetManager.updateAppWidget(getStateScreen(context, "gis"), VIEWS_GIS)
        Log.d("My", getStateScreen(context, "gis").toString())
    }
}


@SuppressLint("SimpleDateFormat", "UnspecifiedImmutableFlag")
suspend fun updateGisViews(context: Context?, appWidgetManager: AppWidgetManager, function: () -> Unit) {
    VIEWS_GIS.apply {
    setViewVisibility(R.id.progress_gis, View.VISIBLE)
        appWidgetManager.updateAppWidget(getStateScreen(context!!, "gis"), this)
    val nowTime = SimpleDateFormat("H:mm").format(Calendar.getInstance().time)
    val nowTimeInt = nowTime.rep
    val sunUp = getOnSitesTemps(GIS_URL, GIS_SUN_UP, 0)!!.rep
    val sunDown = getOnSitesTemps(GIS_URL, GIS_SUN_DOWN, 0)!!.rep
    val value = getOnSitesTemps(GIS_URL, GIS_DIV_TAG, flag = 3)?.sA?.sB!!
        setTextViewText(R.id.gis_time, nowTime)
        setOnClickPendingIntent(
            R.id.image_now_gis,
            PendingIntent.getActivity(
                context, 0,
                Intent(context, DetailGisActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), 0)
        )
        setOnClickPendingIntent(
            R.id.image_gis,
            getPendingSelfIntent(context, "update", Gismeteo::class.java)
        )
        setTextViewText(R.id.gis_text, getOnSitesTemps(GIS_URL_TOD, GIS_TEMP_TOD)?.repPlus + " °C")

        if (nowTimeInt in sunUp..sunDown || nowTimeInt in sunDown..sunUp
        ) {
            setImageViewResource(R.id.image_now_gis, getIconDayGis(value))
            setViewVisibility(R.id.progress_gis, View.GONE)
            function()
        } else {
            setImageViewResource(R.id.image_now_gis, getIconNightGis(value))
            setViewVisibility(R.id.progress_gis, View.GONE)
            function()
        }
    }
}

