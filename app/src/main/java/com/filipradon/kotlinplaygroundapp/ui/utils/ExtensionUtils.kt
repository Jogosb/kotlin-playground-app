package com.filipradon.kotlinplaygroundapp.ui.utils

import java.text.DateFormat
import java.util.Locale

/**
 * Created by filipradon on 26/09/17.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}