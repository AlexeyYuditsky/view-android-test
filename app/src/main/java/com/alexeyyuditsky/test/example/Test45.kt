package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

suspend fun main() {
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    val job1 = scope.async(start = CoroutineStart.LAZY) {
        println(1)
        delay(1000)
    }

    val job2 = scope.async(start = CoroutineStart.LAZY) {
        println(2)
        delay(2000)
    }

    println("wait")

    job1.await()
    job2.await()
}