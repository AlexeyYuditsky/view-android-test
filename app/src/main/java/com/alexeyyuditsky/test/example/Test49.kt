package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

suspend fun main() {
    val scope = CoroutineScope(Dispatchers.IO)

    val job = scope.launch {

        launch {
            delay(100)
            println("b")
        }

        val def = async {
            println("async")
            throw CancellationException()
        }
        try {
            def.await()
        } catch (e: Exception) {
            println("catch")
        }
    }

    job.join()

}