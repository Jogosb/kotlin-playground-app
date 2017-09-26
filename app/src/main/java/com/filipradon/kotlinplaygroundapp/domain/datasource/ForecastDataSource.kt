package com.filipradon.kotlinplaygroundapp.domain.datasource

import com.filipradon.kotlinplaygroundapp.domain.model.Forecast
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList

/**
 * Created by filipradon on 25/09/17.
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}