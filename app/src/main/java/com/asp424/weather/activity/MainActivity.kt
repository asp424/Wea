package com.asp424.weather.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.TextUnit
import com.asp424.weather.ui.anim.TextAnim
import com.asp424.weather.ui.screens.Settings


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Settings()
        }
    }
}




