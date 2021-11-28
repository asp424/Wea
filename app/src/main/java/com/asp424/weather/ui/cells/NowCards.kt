package com.asp424.weather.ui.cells

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.asp424.weather.R
import org.json.JSONObject


@Composable
fun Yandex(dataMyCity: JSONObject) {
    Card(
        modifier = Modifier.padding(bottom = 10.dp),
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.back)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(start = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Value(string = dataMyCity.getString("yan_temp"))
                Image(
                    painter = rememberImagePainter(
                        when (dataMyCity.getString("yan_rain_now")) {
                            "Небольшой дождь" -> R.drawable.gis_n
                            "Ясно" -> R.drawable.gis_b
                            "Небольшой снег" -> R.drawable.gis_a
                            "Пасмурно" -> R.drawable.gis_i
                            "Облачно с прояснениями" -> R.drawable.gis_c
                            else -> {
                                R.drawable.logo
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
fun GidroMet(dataMyCity: JSONObject) {
    Card(
        modifier = Modifier.padding(bottom = 10.dp),
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.background)
    ) {
        Row(
            modifier = Modifier.padding(start = 6.dp), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Value(string = dataMyCity.getString("hydro_temp"))
            Image(
                painter = rememberImagePainter(
                    when (dataMyCity.getString("hydro_now_rain")) {
                        "Ливневый дождь со снегом" -> "https://meteoinfo.ru/images/ico/24d_s.png"
                        "Количество облаков не изменилось" -> "https://meteoinfo.ru/images/ico/5d_s.png"
                        "Облачно с прояснениями, без осадков" -> "https://meteoinfo.ru/images/ico/6d_s.png"
                        "Снег умеренный непрерывный" -> "https://meteoinfo.ru/images/ico/2d_s.png"
                        "Облачно, кратковременный снег" -> "https://meteoinfo.ru/images/ico/13d_s.png"
                        "Облачно, временами небольшие осадки" -> "https://meteoinfo.ru/images/ico/15d_s.png"
                        "Снег слабый непрерывный" -> "https://meteoinfo.ru/images/ico/2d_s.png"
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
    }
}


@Composable
fun GisMeteo(dataMyCity: JSONObject) {
    Card(
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.light)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Value(string = dataMyCity.getString("gis_temp"))
                Value(string = dataMyCity.getString("gis_rain_now"))
                Image(
                    painter = rememberImagePainter(
                        when (dataMyCity.getString("gis_rain_now")) {
                            "Пасмурно, небольшой дождь" -> R.drawable.gis_n
                            "Пасмурно, дождь" -> R.drawable.gis_l
                            "Пасмурно, сильный дождь" -> R.drawable.gis_m
                            "Переменная облачность, небольшой дождь" -> R.drawable.gis_k
                            "Переменная облачность, дождь" -> R.drawable.gis_j
                            "Облачно" -> R.drawable.gis_c
                            "Пасмурно" -> R.drawable.gis_i
                            "Пасмурно, снег" -> R.drawable.gis_h
                            "Пасмурно, снег с дождём" -> R.drawable.gis_e
                            "Малооблачно" -> R.drawable.gis_g
                            "Малооблачно, поземок" -> R.drawable.gis_g
                            "Ясно, поземок" -> R.drawable.gis_b
                            "Малооблачно, ливневый снег" -> R.drawable.gis_f
                            "Пасмурно, мокрый снег" -> R.drawable.gis_e
                            "Переменная облачность" -> R.drawable.gis_c
                            "Переменная облачность, небольшой снег" -> R.drawable.gis_d
                            "Ясно" -> R.drawable.gis_b
                            "Пасмурно, небольшой снег" -> R.drawable.gis_a
                            else -> {
                                R.drawable.logo
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



