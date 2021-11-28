package com.asp424.weather.ui.widgets.yandex.cells

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.asp424.weather.R
import com.asp424.weather.ui.cells.Header
import com.asp424.weather.ui.cells.RowCards
import com.asp424.weather.ui.cells.Logo
import org.json.JSONObject

@Composable
fun ColumnDetailYan(
    json: JSONObject
) {
    val listHour = listOf("Утром", "Днём", "Вечером", "Ночью")
    json.apply {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header(string = "Сегодня", color = Color.Black)
            RowCards {
                for (i in 0..3) {
                    CardDetailYan(
                        time = listHour[i],
                        rain = getString("yan_temp_rain$i"),
                        index = i, temp = getString("yan_temp_tod$i")
                    )
                }
            }
            Header(string = "Завтра", color = Color.Black)
            RowCards {
                for (i in 4..7) {
                    CardDetailYan(
                        time = listHour[i - 4],
                        rain = getString("yan_temp_rain_t$i"),
                        index = i, temp = getString("yan_temp_tom$i")
                    )}
            }
            Logo(R.drawable.yan_logo)
        }
    }
}