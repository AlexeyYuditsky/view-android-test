package com.alexeyyuditsky.test.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking(Dispatchers.Main) {
    flowOf(1)
        .map {
            println(Thread.currentThread().name)
            it
        }
        .flowOn(Dispatchers.IO)
        .filter {
            println(Thread.currentThread().name)
            true
        }
        .flowOn(Dispatchers.Default)
        .single()
}
