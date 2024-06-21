package com.alexeyyuditsky.test.example

import kotlinx.coroutines.flow.flow

suspend fun main() {
    val list = (1..10).toList()
    val flow = flow {
        list.forEach {
            emit(it)
        }
    }

    flow.collect {
        println(it)
    }

}