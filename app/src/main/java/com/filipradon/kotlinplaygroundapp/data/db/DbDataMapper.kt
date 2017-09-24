package com.filipradon.kotlinplaygroundapp.data.db

import com.filipradon.kotlinplaygroundapp.domain.model.Forecast
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList

/**
 * Created by filipradon on 24/09/17.
 */
class DbDataMapper {

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it)}
        ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }

}