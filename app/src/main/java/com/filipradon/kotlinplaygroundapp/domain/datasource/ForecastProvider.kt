package com.filipradon.kotlinplaygroundapp.domain.datasource

import com.filipradon.kotlinplaygroundapp.data.db.ForecastDb
import com.filipradon.kotlinplaygroundapp.data.server.ForecastServer
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList
import com.filipradon.kotlinplaygroundapp.ui.utils.firstResult

/**
 * Created by filipradon on 25/09/17.
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList
            = sources.firstResult { requestSource(it, days, zipCode) }

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if(res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

}