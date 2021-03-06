package com.filipradon.kotlinplaygroundapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.filipradon.kotlinplaygroundapp.R
import com.filipradon.kotlinplaygroundapp.domain.model.Forecast
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList
import com.filipradon.kotlinplaygroundapp.ui.utils.ctx
import com.filipradon.kotlinplaygroundapp.ui.utils.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.date
import kotlinx.android.synthetic.main.item_forecast.view.description
import kotlinx.android.synthetic.main.item_forecast.view.icon
import kotlinx.android.synthetic.main.item_forecast.view.maxTemperature
import kotlinx.android.synthetic.main.item_forecast.view.minTemperature

/**
 * Created by filipradon on 16/09/17.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }
}