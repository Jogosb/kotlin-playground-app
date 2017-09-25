package com.filipradon.kotlinplaygroundapp.data.db

import com.filipradon.kotlinplaygroundapp.domain.datasource.ForecastDataSource
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList
import com.filipradon.kotlinplaygroundapp.ui.utils.clear
import com.filipradon.kotlinplaygroundapp.ui.utils.parseList
import com.filipradon.kotlinplaygroundapp.ui.utils.parseOpt
import com.filipradon.kotlinplaygroundapp.ui.utils.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by filipradon on 23/09/17.
 */
class ForecastDb(
        val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
        val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? " + "AND ${DayForecastTable.DATE} >= ?"

        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null

    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)
        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}




