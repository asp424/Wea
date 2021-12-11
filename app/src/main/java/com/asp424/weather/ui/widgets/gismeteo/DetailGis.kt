package com.asp424.weather.ui.widgets.gismeteo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.asp424.weather.activity.DetailGisActivity
import com.asp424.weather.data.view_states.InternetResponse
import com.asp424.weather.ui.cells.DetailCard
import com.asp424.weather.ui.cells.Loading
import com.asp424.weather.ui.widgets.gismeteo.cells.ColumnDetail
import com.asp424.weather.ui.viewmodel.DetailGisViewModel
import com.asp424.weather.utilites.addItem
import com.asp424.weather.utilites.addToList

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun DetailGis(viewModel: DetailGisViewModel) {
    val values by remember(viewModel) { viewModel.internetValues }.collectAsState()
    val listTod = remember { mutableListOf<String>() }
    val listTom = remember { mutableListOf<String>() }
    val context = LocalContext.current as DetailGisActivity
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    when (values) {
        is InternetResponse.OnSuccess -> {
            DetailCard {
                (values as InternetResponse.OnSuccess).dataValues.apply {
                    listTod.addToList(getString("gis_temp_tod"))
                    listTom.addToList(getString("gis_temp_tom"))
                    ColumnDetail(
                        listTod, listTom,
                        mutableListOf<String>().addItem(getString("gis_icon_tod")),
                        mutableListOf<String>().addItem(getString("gis_icon_tom"))
                    )
                }
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


