package com.alexeyyuditsky.test.test

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val supervisorJob = SupervisorJob()

    val childJob1 = launch(supervisorJob) {
        delay(100)
        try {
            throw RuntimeException("Exception in coroutine 1")
        } catch (e:Exception) {

        }
    }

    val childJob2 = launch(supervisorJob) {
        delay(200)
        println("Coroutine 2 completed")
    }

    childJob1.join() // Ждем завершения первой корутины

    // Отменяем родительскую задачу (SupervisorJob)
    supervisorJob.cancel()

    delay(500) // Даем времени для завершения второй корутины

    println("Main coroutine completed")
}