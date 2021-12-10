package com.asp424.weather.ui.widgets.yandex.cells

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asp424.weather.R
import com.asp424.weather.ui.cells.Header
import com.asp424.weather.ui.cells.RowCards
import com.asp424.weather.ui.cells.Logo
import com.asp424.weather.ui.cells.Visibility
import org.json.JSONObject

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ColumnDetailYan(
    json: JSONObject
) {
    var about by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
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
                    ){
                        about = it.replace("&nbsp;", " ")
                        visible = true
                    }
                }
            }
            Header(string = "Завтра", color = Color.Black)
            RowCards {
                for (i in 4..7) {
                    CardDetailYan(
                        time = listHour[i - 4],
                        rain = getString("yan_temp_rain_t$i"),
                        index = i - 4 , temp = getString("yan_temp_tom$i")
                    ){
                        about = it.replace("&nbsp;", " ")
                        visible = true
                    }}
            }
            Visibility(visible = visible) {
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Card(shape = RoundedCornerShape(3.dp), border = BorderStroke(2.dp, Color.Black), backgroundColor = Color.Black) {
                        Header(string = about, color = Color.White, fontSize = 12.sp, paddingTop = 8.dp,
                            paddingBottom = 8.dp, paddingEnd = 8.dp, paddingStart = 8.dp
                        )
                    }
                }
            }
            Logo(R.drawable.yan_logo, 1)
        }
    }
}