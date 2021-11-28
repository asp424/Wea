package com.asp424.weather.ui.widgets.gismeteo.cells

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.asp424.weather.ui.cells.Header
import com.asp424.weather.ui.cells.RowCards

@Composable
fun ColumnDetailCellGis(
    header: String,
    inRow1: @Composable (RowScope) -> Unit,
    inRow2: @Composable (RowScope) -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Header(string = header, color = Color.Black)
        RowCards {
            inRow1(it)
        }
        RowCards {
            inRow2(it)
        }
    }
}