package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main() {
    val scope = CoroutineScope(Dispatchers.Default)
    val sharedFlow = MutableSharedFlow<Int>()

    val producer = scope.launch {
        repeat(10) {
            println("Emitted: $it")
            sharedFlow.emit(it)
            println("After emit: $it")
            delay(200)
        }
    }

    val consumer = scope.launch {
        sharedFlow.collect {
            println("Collected: $it")
            delay(1000)
        }
    }

    producer.join()
    consumer.join()
}