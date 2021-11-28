package com.asp424.weather.ui.widgets.gismeteo.cells

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.asp424.weather.R
import com.asp424.weather.ui.cells.Logo


@Composable
fun ColumnDetail(
    listTod: MutableList<String>,
    listTom: MutableList<String>,
    listSkyTod: MutableList<String>,
    listSkyTom: MutableList<String>
) {
    Column {
        ColumnDetailCellGis(header = "Сегодня", inRow1 = {
            listTod.takeLast(8).take(4).forEachIndexed { i, item ->
                CardDetailGis(i, listSkyTod[i], item, 0..2, i)
            }
        }) {
            listTod.takeLast(4).forEachIndexed { i, item ->
                CardDetailGis(
                    i, listSkyTod[4 + i], item, 2..3, 4 + i
                )
            }
        }
        ColumnDetailCellGis(header = "Завтра", inRow1 = {
            listTom.takeLast(8).take(4).forEachIndexed { i, item ->
                CardDetailGis(i, listSkyTom[i], item, 0..2, i)
            }
        }, inRow2 = {
            listTom.takeLast(4).forEachIndexed { i, item ->
                CardDetailGis(i, listSkyTom[4 + i], item, 2..3, 4 + i)
            }
        })
        Logo(R.drawable.gismeteo_logo)
    }
}