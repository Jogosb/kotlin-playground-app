package com.filipradon.kotlinplaygroundapp.ui.utils

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by filipradon on 26/09/17.
 */
public fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)