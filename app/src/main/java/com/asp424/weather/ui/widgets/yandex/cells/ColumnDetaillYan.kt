package com.asp424.weather.ui.widgets.yandex.cells

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
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
fun ColumnDetailYan(json: JSONObject) {
    var about by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    val listHour = listOf("Утром", "Днём", "Вечером", "Ночью")
    val listColor = remember { mutableStateOf(MutableList(8){White})}
    var s by remember { mutableStateOf(0) }
    Text(text = s.toString(), fontSize = 1.sp)
    json.apply {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header(string = "Сегодня", color = Color.Black)
            RowCards {
                for (i in 0..3) {
                    CardDetailYan(
                        time = listHour[i],
                        rain = getString("yan_temp_rain$i"),
                        index = i, temp = getString("yan_temp_tod$i"), color = listColor.value[i]
                    ){
                        for (a in 0..7){ listColor.value[a] = White }
                        listColor.value[i] = LightGray
                        about = it.replace("&nbsp;", " ")
                        visible = true
                        s++
                    }
                }
            }
            Header(string = "Завтра", color = Color.Black)
            RowCards {
                for (i in 4..7) {
                    CardDetailYan(
                        time = listHour[i - 4],
                        rain = getString("yan_temp_rain_t$i"),
                        index = i - 4 , temp = getString("yan_temp_tom$i"), color = listColor.value[i]
                    ){
                        for (a in 0..7){ listColor.value[a] = White }
                        listColor.value[i] = LightGray
                        about = it.replace("&nbsp;", " ")
                        visible = true
                        s++
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