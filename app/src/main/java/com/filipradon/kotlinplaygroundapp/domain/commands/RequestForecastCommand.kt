package com.filipradon.kotlinplaygroundapp.domain.commands

import com.filipradon.kotlinplaygroundapp.domain.datasource.ForecastProvider
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList

/**
 * Created by filipradon on 16/09/17.
 */
class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}
