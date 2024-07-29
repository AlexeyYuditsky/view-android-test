package com.alexeyyuditsky.test.example

import kotlinx.coroutines.flow.flow

suspend fun main() {
    flow.collect {
        println(it)
    }
}

val flow = flow {
    try {
        repeat(5) {
            emit(it)
        }
        throw RuntimeException()
    } catch (e: Exception) {

    }
}