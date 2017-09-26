package com.filipradon.kotlinplaygroundapp.domain.commands

import com.filipradon.kotlinplaygroundapp.domain.datasource.ForecastProvider
import com.filipradon.kotlinplaygroundapp.domain.model.Forecast

/**
 * Created by filipradon on 26/09/17.
 */
class RequestDayForecastCommand(
        val id: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)

}