package com.filipradon.kotlinplaygroundapp.ui.utils

/**
 * Created by filipradon on 24/09/17.
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()