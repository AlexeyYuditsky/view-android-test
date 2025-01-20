package com.alexeyyuditsky.test.example.other

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun main() {
    val job = CoroutineScope(Dispatchers.IO).launch {
        println("start")
        delay(1000)
        withContext(NonCancellable) {
            println("withContext")
            println("end")
        }
        println("end2")
    }

    job.cancel()
    Thread.sleep(2000)
}