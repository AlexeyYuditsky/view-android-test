package com.alexeyyuditsky.test.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

suspend fun main() {
    val numbers = (1..10).asFlow()

    numbers
        .filter { test(it) }
        .filter { it > 5 }
        .map { "Number: $it" }
        .collect { println(it) }
}

suspend fun test(value: Int): Boolean {
    delay(500)
    return value % 2 == 0
}