package com.alexeyyuditsky.test.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main() {
    val flow = MutableSharedFlow<Int>()

    coroutineScope.launch {
        repeat(5) {
            println("Emitted: $it ${Thread.currentThread().name}")
            flow.emit(it)
            delay(1000)
        }
    }

    val job1 = coroutineScope.launch {
        flow.collect {
            println("first collect: $it ${Thread.currentThread().name}")
        }
    }

    delay(5000)

    val job2 = coroutineScope.launch {
        flow.collect {
            println("second collect: $it ${Thread.currentThread().name}")
        }
    }

    job1.join()
    job2.join()
}