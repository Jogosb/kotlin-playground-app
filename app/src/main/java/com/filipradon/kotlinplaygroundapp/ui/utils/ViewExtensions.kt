package com.filipradon.kotlinplaygroundapp.ui.utils

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by filipradon on 18/09/17.
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)