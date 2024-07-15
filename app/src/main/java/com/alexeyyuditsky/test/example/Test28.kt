package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

val exceptionHandler = CoroutineExceptionHandler { i, t ->
    println(i)
    println(t)
}
val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler)

suspend fun main() {
    val flow = getFlow()

    val job1 = coroutineScope.launch {
        flow.first().let {
            println(it)
        }
    }

    delay(5000)

    val job2 = coroutineScope.launch {
        flow.collect {
            println(it)
        }
    }

    job1.join()
    job2.join()
}

fun getFlow(): Flow<Int> = flow {
    repeat(5) {
        println("Emitted: $it")
        emit(it)
        delay(1000)
    }
}