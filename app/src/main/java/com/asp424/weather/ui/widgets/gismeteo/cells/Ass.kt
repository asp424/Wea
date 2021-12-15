package com.asp424.weather.ui.widgets.gismeteo.cells

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    Scaffold(topBar = {
        TopBarTest()
    }, content = {
        Text(text = "content")
    })
}

@Composable
fun TopBarTest() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "TopBar", color = White)
    }
}