package com.asp424.weather.ui.cells

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.asp424.weather.R
import org.json.JSONObject

@Composable
fun YandexF(put: JSONObject) {
    Card(
        modifier = Modifier.padding(bottom = 10.dp),
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.back)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(stringResource(id = R.string.yandex_name))
            Row(modifier = Modifier.padding(8.dp)) {
                Column {

                }
                Column(
                    modifier = Modifier.padding(start = 5.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                }
            }
        }
    }
}

@Composable
fun GidroMetF(dataMyCity: JSONObject) {
    Card(
        modifier = Modifier.padding(bottom = 10.dp),
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 16.dp, start = 6.dp)) {
                Value(string = dataMyCity.getString("hydro_today_temp"))
                Image(
                    painter = rememberImagePainter(
                        when (dataMyCity.getString("hydro_today_rain")) {
                            "Ливневый дождь со снегом" -> "https://meteoinfo.ru/images/ico/24d_s.png"
                            "Количество облаков не изменилось" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                            "Небольшая облачность, без осадков" -> "https://meteoinfo.ru/images/ico/7d_s.png"
                            "Облачно с прояснениями, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                            "Снег умеренный непрерывный" -> "https://meteoinfo.ru/images/ico/2d_s.png"
                            "Облачно, кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                            "Облачно, временами небольшие осадки" -> "https://meteoinfo.ru/images/ico/15d_s.png"
                            "Облачно, без осадков" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                            "Облачно с прояснениями, временами небольшой снег" -> "https://meteoinfo.ru/images/ico/12d_s.png"
                            "Переменная облачность, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                            "Облачно, небольшой кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                            else -> {
                                "https://meteoinfo.ru/images/ico/5d_s.png"
                            }
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(38.dp)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 16.dp)) {

                Value(string = dataMyCity.getString("hydro_tom_temp_d"))
                        Image(
                            painter = rememberImagePainter(
                                when (dataMyCity.getString("hydro_tom_rain_d")) {
                                    "Ливневый дождь со снегом" -> "https://meteoinfo.ru/images/ico/24d_s.png"
                                    "Количество облаков не изменилось" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                                    "Небольшая облачность, без осадков" -> "https://meteoinfo.ru/images/ico/7d_s.png"
                                    "Облачно с прояснениями, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                                    "Снег умеренный непрерывный" -> "https://meteoinfo.ru/images/ico/2d_s.png"
                                    "Облачно, кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                                    "Облачно, временами небольшие осадки" -> "https://meteoinfo.ru/images/ico/15d_s.png"
                                    "Облачно, без осадков" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                                    "Облачно с прояснениями, временами небольшой снег" -> "https://meteoinfo.ru/images/ico/12d_s.png"
                                    "Переменная облачность, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                                    "Облачно, небольшой кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                                    else -> {
                                        "https://meteoinfo.ru/images/ico/5d_s.png"
                                    }
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(38.dp)
                        )
                    }

                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 6.dp)
                    ) {
                        Value(string = dataMyCity.getString("hydro_tom_temp_n"))
                        Image(
                            painter = rememberImagePainter(
                                when (dataMyCity.getString("hydro_tom_rain_n")) {
                                    "Ливневый дождь со снегом" -> "https://meteoinfo.ru/images/ico/24n_s.png"
                                    "Количество облаков не изменилось" -> "https://meteoinfo.ru/images/ico/5n_s.png"
                                    "Небольшая облачность, без осадков" -> "https://meteoinfo.ru/images/ico/7n_s.png"
                                    "Облачно с прояснениями, без осадков" -> "https://meteoinfo.ru/images/ico/6n_s.png"
                                    "Снег умеренный непрерывный" -> "https://meteoinfo.ru/images/ico/2n_s.png"
                                    "Облачно, кратковременный снег" -> "https://meteoinfo.ru/images/ico/13n_s.png"
                                    "Облачно, временами небольшие осадки" -> "https://meteoinfo.ru/images/ico/15n_s.png"
                                    "Облачно, без осадков" -> "https://meteoinfo.ru/images/ico/5n_s.png"
                                    "Облачно с прояснениями, временами небольшой снег" -> "https://meteoinfo.ru/images/ico/12n_s.png"
                                    "Переменная облачность, без осадков" -> "https://meteoinfo.ru/images/ico/6n_s.png"
                                    "Облачно, небольшой кратковременный снег" -> "https://meteoinfo.ru/images/ico/13n_s.png"
                                    else -> {
                                        "https://meteoinfo.ru/images/ico/5d_s.png"
                                    }
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                }
            }
}

@Composable
fun GisMeteoF(put: JSONObject) {
    Card(
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.light)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(stringResource(id = R.string.gismeteo_name))
            Row(modifier = Modifier.padding(8.dp)) {
                Column {

                }
                Column(
                    modifier = Modifier.padding(start = 5.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                }
            }
        }
    }
}



