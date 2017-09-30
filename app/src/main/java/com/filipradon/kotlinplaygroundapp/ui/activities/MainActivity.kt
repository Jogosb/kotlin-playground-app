package com.filipradon.kotlinplaygroundapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.filipradon.kotlinplaygroundapp.R
import com.filipradon.kotlinplaygroundapp.domain.commands.RequestForecastCommand
import com.filipradon.kotlinplaygroundapp.ui.adapters.ForecastListAdapter
import com.filipradon.kotlinplaygroundapp.ui.utils.DelegatesExtensions
import kotlinx.android.synthetic.main.activity_main.forecastList
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(), ToolbarManager {

    private val zipCode: Long by DelegatesExtensions.preference(this, SettingsActivity.ZIP_CODE,
            SettingsActivity.DEFAULT_ZIP)

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)

    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() {
        doAsync {
            val result = RequestForecastCommand(zipCode).execute()
            uiThread {
                val adapter = ForecastListAdapter(result) {
                    startActivity<DetailsActivity>(DetailsActivity.ID to it.id,
                            DetailsActivity.CITY_NAME to result.city)
                }
                forecastList.adapter = adapter
                toolbarTitle = "${result.city} (${result.country})"
            }
        }
    }
}