package com.filipradon.kotlinplaygroundapp.domain.commands

/**
 * Created by filipradon on 16/09/17.
 */
interface Command<out T> {
    fun execute(): T
}