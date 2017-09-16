package com.filipradon.kotlinplaygroundapp.domain.commands

import com.filipradon.kotlinplaygroundapp.data.ForecastRequest
import com.filipradon.kotlinplaygroundapp.domain.mappers.ForecastDataMapper
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList

/**
 * Created by filipradon on 16/09/17.
 */
class RequestForecastCommand(val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
