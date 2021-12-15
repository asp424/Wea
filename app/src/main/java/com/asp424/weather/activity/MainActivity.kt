package com.asp424.weather.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.asp424.weather.ui.screens.Settings
import com.asp424.weather.ui.widgets.gismeteo.cells.Test


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Settings()
        }
    }
}




