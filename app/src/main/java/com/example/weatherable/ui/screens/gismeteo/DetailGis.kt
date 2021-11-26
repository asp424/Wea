package com.example.weatherable.ui.screens.gismeteo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.example.weatherable.activity.DetailGisActivity
import com.example.weatherable.data.view_states.InternetResponse
import com.example.weatherable.ui.cells.Loading
import com.example.weatherable.ui.screens.gismeteo.cells.ColumnDetail
import com.example.weatherable.ui.viewmodel.DetailGisViewModel
import com.example.weatherable.utilites.addItem
import com.example.weatherable.utilites.addToList

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun DetailGis(viewModel: DetailGisViewModel) {
    val values by remember(viewModel) { viewModel.internetValues }.collectAsState()
    val listTod = remember { mutableListOf<String>() }
    val listTom = remember { mutableListOf<String>() }
    val context = LocalContext.current as DetailGisActivity
    when (values) {
        is InternetResponse.OnSuccess -> {
            Column(Modifier.wrapContentHeight().fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RoundedCornerShape(16.dp), modifier = Modifier.wrapContentSize()
                ) {
                    (values as InternetResponse.OnSuccess).dataValues.apply {
                    val listSkyTod = mutableListOf<String>().addItem(getString("gis_icon_tod"))
                    val listSkyTom = mutableListOf<String>().addItem(getString("gis_icon_tom"))
                        listTod.addToList(getString("gis_temp_tod"))
                        listTom.addToList(getString("gis_temp_tom"))
                        ColumnDetail(listTod, listTom, listSkyTod, listSkyTom)
                    }
                }
            }
        }
        is InternetResponse.Loading -> Loading(context)
        else -> {}
    }
    LocalLifecycleOwner.current.lifecycle.addObserver(viewModel)
}


