package com.filipradon.kotlinplaygroundapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

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

        val forecastList = findViewById<RecyclerView>(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(forecastItems)
    }
}
