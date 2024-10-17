package com.alexeyyuditsky.test.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() = runBlocking {
    coroutineScope {
        launch {
            println("aaa")
            delay(1000)
            println("bbb")
        }

        cancel()
    }
}