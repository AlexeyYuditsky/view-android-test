package com.alexeyyuditsky.test.example

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun main() {
    test().collect { println(it) }
}

fun test(): Flow<Int> = flow {
    repeat(10) {
        emit(it)
    }
}