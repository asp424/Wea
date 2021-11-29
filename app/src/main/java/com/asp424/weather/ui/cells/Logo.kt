package com.asp424.weather.ui.cells

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun Logo(path: Int, urlTag: Int) {
    val intent = remember {
        when (urlTag) {
            0 -> {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.gismeteo.ru/weather-chelyabinsk-4565/")
                )
            }
            1 ->  Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://yandex.ru/pogoda/chelyabinsk/details/")
            )
            else -> Intent(
                Intent.ACTION_VIEW,
                Uri.parse("")
            )
        }
    }
    val context = LocalContext.current
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberImagePainter(path),
            contentDescription = null,
            modifier = Modifier
                .size(58.dp)
                .clickable {
                    context.startActivity(
                        intent
                    )
                }
        )
    }
}