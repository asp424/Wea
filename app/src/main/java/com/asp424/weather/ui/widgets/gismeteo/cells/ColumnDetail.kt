package com.asp424.weather.ui.widgets.gismeteo.cells

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
import com.asp424.weather.ui.cells.Logo
import com.asp424.weather.ui.cells.Visibility


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ColumnDetail(
    listTemp: MutableList<String>,
    listIcon: MutableList<String>
) {
    var about by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    Column {
        ColumnDetailCellGis(header = "Сегодня", inRow1 = {
            listTemp.takeLast(8).take(4).forEachIndexed { i, item ->
                CardDetailGis(i, listIcon[i], item, 0..2, i){
                    about = it.replace("&nbsp;", " ")
                    visible = true
                }
            }
        }) {
            listTemp.takeLast(4).forEachIndexed { i, item ->
                CardDetailGis(
                    i, listIcon[4 + i], item, 2..3, 4 + i
                ){
                    about = it.replace("&nbsp;", " ")
                    visible = true
                }
            }
        }
        ColumnDetailCellGis(header = "Завтра", inRow1 = {
            listTemp.takeLast(8).take(4).forEachIndexed { i, item ->
                CardDetailGis(i, listIcon[i], item, 0..2, i){
                    about = it.replace("&nbsp;", " ")
                    visible = true
                }
            }
        }, inRow2 = {
            listTemp.takeLast(4).forEachIndexed { i, item ->
                CardDetailGis(i, listIcon[4 + i], item, 2..3, 4 + i){
                    about = it.replace("&nbsp;", " ")
                    visible = true
                }
            }
        })
        Visibility(visible = visible) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(shape = RoundedCornerShape(3.dp), border = BorderStroke(2.dp, Color.Black), backgroundColor = Color.Black) {
                    Header(string = about, color = Color.White, fontSize = 12.sp, paddingTop = 8.dp,
                        paddingBottom = 8.dp, paddingEnd = 8.dp, paddingStart = 8.dp
                    )
                }
            }
        }
        Logo(R.drawable.gismeteo_logo, 0)
    }
}