package com.example.weatherable.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.weatherable.application.appComponent
import com.example.weatherable.ui.cells.NavController
import com.example.weatherable.ui.viewmodel.MainViewModel
import dagger.Lazy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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

@Composable
fun A() {
    var scale by remember { mutableStateOf(1f) }
    val coroutine = rememberCoroutineScope()
    var text by remember { mutableStateOf(0) }
    var color by remember { mutableStateOf( Color.Green) }
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Card(modifier = Modifier
            .size(100.dp)
            .padding(bottom = 10.dp)
            .graphicsLayer {
                translationX = scale
            }, backgroundColor = color
        ) { Text(text = text.toString(), textAlign = TextAlign.Center, modifier = Modifier.padding(top = 30.dp), fontSize = 30.sp
            ) } }
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
        ) {
        Card(modifier = Modifier
            .size(100.dp)
            .padding(bottom = 10.dp)
            .graphicsLayer { translationX = scale - 1002f }, backgroundColor = if (color == Color.Yellow) Color.Green else Color.Yellow
        ) { Text(text = (text + 1).toString(), textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 30.dp), fontSize = 30.sp) } }
    Column(Modifier.fillMaxSize().padding(bottom = 100.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { coroutine.launch { while (scale != 1001f) { scale += 2f
            delay(1L)
            if (scale == 1001f) { text ++
                scale = 1f
                color = if (color == Color.Yellow) Color.Green else Color.Yellow
                break } } } }) { Text(text = "start") } }
    }


