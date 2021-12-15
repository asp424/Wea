package com.asp424.weather.ui.widgets.gismeteo.cells

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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asp424.weather.R
import com.asp424.weather.ui.cells.Header
import com.asp424.weather.ui.cells.Logo
import com.asp424.weather.ui.cells.Visibility


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ColumnDetail(
    listTod: MutableList<String>,
    listTom: MutableList<String>,
    listSkyTod: MutableList<String>,
    listSkyTom: MutableList<String>
) {
    var about by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    var listColorTod by remember { mutableStateOf(MutableList(8){ White })}
    var listColorTom by remember { mutableStateOf(MutableList(8){ White })}
    var s by remember { mutableStateOf(0) }
    Text(text = s.toString(), fontSize = 1.sp)
    Column {
        ColumnDetailCellGis(header = "Сегодня", inRow1 = {
            listTod.takeLast(8).take(4).forEachIndexed { i, item ->
                CardDetailGis(color = listColorTod[i], i, listSkyTod[i], item, 0..2, i){
                    listColorTod = setWhite()
                    listColorTom = setWhite()
                    listColorTod[i] = LightGray
                    about = it.replace("&nbsp;", " ")
                    visible = true
                    s++
                }
            }
        }) {
            listTod.takeLast(4).forEachIndexed { i, item ->
                CardDetailGis(color = listColorTod[i + 4],
                    i, listSkyTod[4 + i], item, 2..3, 4 + i
                ){
                    listColorTod = setWhite()
                    listColorTom = setWhite()
                    listColorTod[i + 4] = LightGray
                    about = it.replace("&nbsp;", " ")
                    visible = true
                    s++
                }
            }
        }
        ColumnDetailCellGis(header = "Завтра", inRow1 = {
            listTom.takeLast(8).take(4).forEachIndexed { i, item ->
                CardDetailGis(color = listColorTom[i], i, listSkyTom[i], item, 0..2, i){
                    listColorTod = setWhite()
                    listColorTom = setWhite()
                    listColorTom[i] = LightGray
                    about = it.replace("&nbsp;", " ")
                    visible = true
                    s++
                }
            }
        }, inRow2 = {
            listTom.takeLast(4).forEachIndexed { i, item ->
                CardDetailGis(color = listColorTom[i + 4], i, listSkyTom[4 + i], item, 2..3, 4 + i){
                    listColorTom = setWhite()
                    listColorTod = setWhite()
                    listColorTom[i + 4] = LightGray
                    about = it.replace("&nbsp;", " ")
                    visible = true
                    s++
                }
            }
        })
        Visibility(visible = visible) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(shape = RoundedCornerShape(3.dp), border = BorderStroke(2.dp, Black), backgroundColor = Black) {
                    Header(string = about, color = White, fontSize = 12.sp, paddingTop = 8.dp,
                        paddingBottom = 8.dp, paddingEnd = 8.dp, paddingStart = 8.dp
                    )
                }
            }
        }
        Logo(R.drawable.gismeteo_logo, 0)
    }
}
private fun setWhite(): MutableList<Color> = MutableList(16) { White }



