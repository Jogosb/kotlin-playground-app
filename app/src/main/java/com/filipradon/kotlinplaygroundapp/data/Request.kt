package com.filipradon.kotlinplaygroundapp.data

import android.util.Log
import java.net.URL

/**
 * Created by filipradon on 16/09/17.
 */
class Request(val url: String) {

    fun run() {
        val forecastJsonString = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonString)
    }
}