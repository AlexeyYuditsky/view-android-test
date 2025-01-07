package com.alexeyyuditsky.test.example.other

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Program started: ${System.currentTimeMillis()}")

    // Создаём корутину с параметром lazy
    val job = launch(start = CoroutineStart.LAZY) {
        println("Lazy coroutine started: ${System.currentTimeMillis()}")
        delay(1000) // Эмулируем работу
        println("Lazy coroutine finished: ${System.currentTimeMillis()}")
    }

    // Корутина не начнет выполнение до вызова start()
    println("Before starting the lazy coroutine")
    delay(2000) // Ждём 2 секунды
    println("Starting lazy coroutine now...")
    job.start() // Явно запускаем корутину

    // Ждем завершения корутины
    job.join()
    println("Program finished: ${System.currentTimeMillis()}")
}