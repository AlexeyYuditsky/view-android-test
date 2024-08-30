package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val job = coroutineScope.launch {
        println("hi")
    }

    println(job.isActive)
    println(job.isCompleted)
    println(job.isCancelled)

    delay(1000)

    println(job.isActive)
    println(job.isCompleted)
    println(job.isCancelled)
}