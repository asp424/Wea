package com.asp424.weather.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.asp424.weather.application.appComponent
import com.asp424.weather.navigation.NavController
import com.asp424.weather.ui.viewmodel.MainViewModel
import dagger.Lazy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: Lazy<ViewModelProvider.Factory>

    @RequiresApi(Build.VERSION_CODES.M)
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        val viewModel = ViewModelProvider(
            this,
            viewModelFactory.get()
        )[MainViewModel::class.java]
        setContent {
            NavController(viewModel)
        }
    }
}




