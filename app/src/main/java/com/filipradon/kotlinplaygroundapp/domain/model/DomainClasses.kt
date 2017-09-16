package com.filipradon.kotlinplaygroundapp.domain.model

/**
 * Created by filipradon on 16/09/17.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)