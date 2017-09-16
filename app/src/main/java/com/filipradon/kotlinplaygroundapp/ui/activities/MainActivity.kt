package com.filipradon.kotlinplaygroundapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.filipradon.kotlinplaygroundapp.R
import com.filipradon.kotlinplaygroundapp.data.Request
import com.filipradon.kotlinplaygroundapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val forecastItems = listOf(
            "Mon 18/09 - Rainy - 20/10",
            "Tue 19/09 - Rainy - 20/10",
            "Wed 20/09 - Rainy - 20/10",
            "Thu 21/09 - Rainy - 20/10",
            "Fri 22/09 - Rainy - 20/10",
            "Sat 22/09 - Rainy - 20/10",
            "Sun 23/09 - Rainy - 20/10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(forecastItems)

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

        doAsync {
            Request(url).run()
            uiThread { longToast("Request performed") }
        }

    }
}
