package com.alexeyyuditsky.test.example.other

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val flow = flow {
        repeat(10) {
            emit(it)
            delay(500) // эмуляция задержки
        }
    }

    // Запуск сбора в отдельной корутине
    launch {
        flow.collect { value ->
            println("Collected: $value")
        }
    }

    // Выполнение других задач
    repeat(5) {
        println("Main task $it")
        delay(1000)
    }
}