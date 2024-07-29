package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

suspend fun main() {
    val scope = CoroutineScope(Dispatchers.Default)
    val sharedFlow = MutableStateFlow<Int>(0)

    val producer = scope.launch {
        delay(500)
        repeat(10) {
            println("Emitted: $it")
            sharedFlow.emit(it)
            println("After emit: $it")
            delay(200)
        }
    }

    val consumer = scope.launch {
        sharedFlow.collectLatest {
            println("Collected: $it")
            delay(5000)
            println("Collected end $it")
        }
    }

    producer.join()
    consumer.join()
}