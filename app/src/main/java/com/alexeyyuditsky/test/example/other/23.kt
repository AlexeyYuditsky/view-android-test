package com.alexeyyuditsky.test.example.other

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val handler = CoroutineExceptionHandler { _, exception ->
    println("Caught undelivered exception: $exception")
}

fun main() = runBlocking {
    val job = launch(handler) {
        try {
            delay(30000)
            throw Exception("Undelivered Exception!")
        } finally {
            println("Job is cancelled before exception is delivered")
        }
    }

    delay(500)
    job.cancel()
    job.join()
}