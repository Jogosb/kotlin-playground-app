package com.filipradon.kotlinplaygroundapp.domain.mappers

import com.filipradon.kotlinplaygroundapp.data.Forecast
import com.filipradon.kotlinplaygroundapp.data.ForecastResult
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

import com.filipradon.kotlinplaygroundapp.domain.model.Forecast as ModelForecast

/**
 * Created by filipradon on 16/09/17.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecastResult: ForecastResult): ForecastList {
        return ForecastList(forecastResult.city.name, forecastResult.city.country,
                convertForecastListToDomain(forecastResult.list))
    }

    fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date: Long): String {
        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dateFormat.format(date)
    }

}