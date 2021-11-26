package com.example.weatherable.ui.screens.gismeteo.cells

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.weatherable.ui.cells.CellHeader

@Composable
fun ColumnDetailCell(
    header: String,
    inRow1: @Composable (RowScope) -> Unit,
    inRow2: @Composable (RowScope) -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CellHeader(string = header, color = Color.Black)
        RowCards {
            inRow1(it)
        }
        RowCards {
            inRow2(it)
        }
    }
}