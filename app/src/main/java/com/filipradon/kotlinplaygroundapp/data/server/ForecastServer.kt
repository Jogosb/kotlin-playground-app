package com.filipradon.kotlinplaygroundapp.data.server

import com.filipradon.kotlinplaygroundapp.data.db.ForecastDb
import com.filipradon.kotlinplaygroundapp.domain.datasource.ForecastDataSource
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList

/**
 * Created by filipradon on 25/09/17.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()

}