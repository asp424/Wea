package com.asp424.weather.utilites

import android.widget.RemoteViews
import com.asp424.weather.R

//Change this URLs for get yours city weather info
//Gis
const val GIS_URL_CHEL = "https://www.gismeteo.ru/weather-chelyabinsk-4565/now/"
const val GIS_URL_KRYM = "https://www.gismeteo.ru/weather-krymsk-5212/now/"
const val GIS_URL_PUSH = "https://www.gismeteo.ru/weather-pushkin-23501/now/"
const val GIS_URL_MOSC = "https://www.gismeteo.ru/weather-moscow-4368/now/"

const val GIS_URL_CHEL_TOD = "https://www.gismeteo.ru/weather-chelyabinsk-4565/"
const val GIS_URL_KRYM_TOD = "https://www.gismeteo.ru/weather-krymsk-5212/"
const val GIS_URL_MOSC_TOD = "https://www.gismeteo.ru/weather-moscow-4368/"
const val GIS_URL_PUSH_TOD = "https://www.gismeteo.ru/weather-pushkin-23501/"

const val GIS_URL_CHEL_TOM = "https://www.gismeteo.ru/weather-chelyabinsk-4565/tomorrow/"
const val GIS_URL_KRYM_TOM = "https://www.gismeteo.ru/weather-krymsk-5212/tomorrow/"
const val GIS_URL_MOSC_TOM = "https://www.gismeteo.ru/weather-moscow-4368/tomorrow/"
const val GIS_URL_PUSH_TOM = "https://www.gismeteo.ru/weather-pushkin-23501/tomorrow/"
//Yandex
const val YAN_URL_CHEL = "https://yandex.ru/pogoda/chelyabinsk"
const val YAN_URL_KRYM = "https://yandex.ru/pogoda/?lat=44.93541336&lon=37.98788834"
const val YAN_URL_MOSC = "https://yandex.ru/pogoda/?lat=55.75581741&lon=37.61764526"
const val YAN_URL_PUSH = "https://yandex.ru/pogoda/?lat=59.72233582&lon=30.41676521"

const val YAN_URL_CHEL_DETAILS = "https://yandex.ru/pogoda/chelyabinsk/details"
const val YAN_URL_KRYM_DETAILS = "https://yandex.ru/pogoda/details?lat=44.93541336&lon=37.98788834&via=ms"
const val YAN_URL_MOSC_DETAILS = "https://yandex.ru/pogoda/details?lat=55.75581741&lon=37.61764526&via=ms"
const val YAN_URL_PUSH_DETAILS = "https://yandex.ru/pogoda/details?lat=59.72233582&lon=30.41676521&via=ms"

//HydroMet
const val GID_URL = "https://meteoinfo.ru/pogoda/russia/chelyabinsk-area/cheljabinsk"
//MSN
const val MSN_DET_URL = "https://www.msn.com/ru-ru/weather/today/%D0%A7%D0%B5%D0%BB%D1%8F%D0%B1%D0%B8%D0%BD%D1%81%D0%BA,%D0%A7%D0%B5%D0%BB%D1%8F%D0%B1%D0%B8%D0%BD%D1%81%D0%BA%D0%B0%D1%8F-%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C,%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F/we-city?form=PRWLAS&iso=RU&el=D4L69jIcm0gpZv66odhSe9FOem89eWf%2Bh1UerWkjXqau4S46757kLCg9vWfkCtJxXXGM%2BnjCuW1D78gzRbWx6iUM7BBoXE0i1P5CceU79E4cZxxyP%2BUM3TpPv7%2Bnl6MXxzIoy70XuwZGtJfpNc1VH8qmzkaR9RnT%2BNUwFIEf3wqhMMM2OjD7sdNxdH79vRmt&weadegreetype=C"
const val MSN_DET_URL_MAP = "https://www.msn.com/ru-ru/weather/maps?lat=55.1601&lon=61.3936&weadegreetype=C&weaext0=%7B%22l%22%3A%22%D0%A7%D0%B5%D0%BB%D1%8F%D0%B1%D0%B8%D0%BD%D1%81%D0%BA%22%2C%22r%22%3A%22%D0%A7%D0%B5%D0%BB%D1%8F%D0%B1%D0%B8%D0%BD%D1%81%D0%BA%D0%B0%D1%8F+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C%22%2C%22c%22%3A%22%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F%22%2C%22i%22%3A%22RU%22%2C%22t%22%3A102%2C%22g%22%3A%22ru-ru%22%7D&type=temperature&city=%D0%A7%D0%B5%D0%BB%D1%8F%D0%B1%D0%B8%D0%BD%D1%81%D0%BA%2C+%D0%A7%D0%B5%D0%BB%D1%8F%D0%B1%D0%B8%D0%BD%D1%81%D0%BA%D0%B0%D1%8F+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C"
const val MSN_NOW_ROW = "summaryLineGroupCompact-DS-EntryPoint1-1"

const val GIS_SUN_UP = "now-astro-sunrise"
const val GIS_SUN_DOWN = "now-astro-sunset"
const val GIS_SUN_UP1 = "nowastro__item nowastro__item_sunrise"
const val GIS_SUN_DOWN1 = "nowastro__item nowastro__item_sunset"

const val GIS_ICON_LIST = "widget-row widget-row-icon"
const val GIS_ICON_LIST1 = "widget__row widget__row_table widget__row_icon"
const val GIS_TEMP_TOD = "unit unit_temperature_c"

const val GIS_DIV_TAG = "div"

const val YAN_TEMP = "temp__value"
const val YAN_TOD_DETAIL_TEMP = "weather-table__temp"
const val YAN_TOD_DETAIL_RAIN = "weather-table__body-cell weather-table__body-cell_type_condition"
const val YAN_RAIN = "link__condition"
const val TAG = "td"
val VIEWS_GIS = RemoteViews("com.asp424.weather", R.layout.gismeteo)
val VIEWS_YAN = RemoteViews("com.asp424.weather", R.layout.yandex)



