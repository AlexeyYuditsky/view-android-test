package com.alexeyyuditsky.test.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

val sharedFlow = MutableSharedFlow<Unit>()

suspend fun main() {
    coroutineScope.launch {
        loadData().collect {
            println(it)
        }
    }

    delay(1000)
    sharedFlow.emit(Unit)

    delay(1000)
    sharedFlow.emit(Unit)
}

fun loadData(): Flow<Int> = flow {
    emit(0)
    println("emit cold")

    sharedFlow.collect {
        emit(1)
        println("emit shared")
    }
}


