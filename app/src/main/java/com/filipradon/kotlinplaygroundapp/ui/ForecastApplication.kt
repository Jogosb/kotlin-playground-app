package com.filipradon.kotlinplaygroundapp.ui

import android.app.Application
import com.filipradon.kotlinplaygroundapp.ui.utils.DelegatesExtensions

/**
 * Created by filipradon on 21/09/17.
 */
class ForecastApplication: Application() {

    companion object {
        var instance: ForecastApplication by DelegatesExtensions.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}