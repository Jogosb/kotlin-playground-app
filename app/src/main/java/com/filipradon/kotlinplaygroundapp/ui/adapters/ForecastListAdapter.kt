package com.filipradon.kotlinplaygroundapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.filipradon.kotlinplaygroundapp.domain.model.ForecastList

/**
 * Created by filipradon on 16/09/17.
 */
class ForecastListAdapter(val weekForecast: ForecastList): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}