package com.filipradon.kotlinplaygroundapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.filipradon.kotlinplaygroundapp.R
import com.filipradon.kotlinplaygroundapp.domain.commands.RequestForecastCommand
import com.filipradon.kotlinplaygroundapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.forecastList
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread {
                val adapter = ForecastListAdapter(result) {
                    startActivity<DetailsActivity>(DetailsActivity.ID to it.id,
                            DetailsActivity.CITY_NAME to result.city)
                }
                forecastList.adapter = adapter
                title = "${result.city} (${result.country})"
            }
        }
    }
}