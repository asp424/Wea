package com.asp424.weather.ui.widgets.yandex

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.asp424.weather.activity.DetailYanActivity
import com.asp424.weather.data.view_states.InternetResponse
import com.asp424.weather.ui.cells.DetailCard
import com.asp424.weather.ui.cells.Loading
import com.asp424.weather.ui.widgets.yandex.cells.ColumnDetailYan
import com.asp424.weather.ui.viewmodel.DetailYanViewModel


@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun DetailYan(viewModel: DetailYanViewModel) {
    val values by remember(viewModel) { viewModel.internetValues }.collectAsState()
    val context = LocalContext.current as DetailYanActivity
    val lifeCycle = LocalLifecycleOwner.current.lifecycle

    when (values) {
        is InternetResponse.OnSuccess -> {
            DetailCard {
                ColumnDetailYan((values as InternetResponse.OnSuccess).dataValues)
            }
        }
        is InternetResponse.Loading -> Loading(context)
        else -> {
        }
    }
    LaunchedEffect(lifeCycle) { lifeCycle.addObserver(viewModel) }
    DisposableEffect(lifeCycle) {
        onDispose { lifeCycle.removeObserver(viewModel) }
    }
}



