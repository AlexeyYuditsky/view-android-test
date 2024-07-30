package com.alexeyyuditsky.test.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retry

suspend fun main() {
    flow
        .map { State.Content(it) as State<*> }
        .onStart { emit(State.Loading) }
        .retry(2) { delay(1000); true }
        .catch { emit(State.Error(it)) }
        .collect { println(it.returnData()) }
}

val flow = flow {
    repeat(5) {
        delay(500)
        emit(it)
    }
    throw RuntimeException()
}

interface State<T> {
    fun returnData(): T
    data class Content(val data: Int) : State<Int> {
        override fun returnData(): Int = data
    }

    data object Loading : State<Unit> {
        override fun returnData() {}
    }

    data class Error(val t: Throwable) : State<Throwable> {
        override fun returnData(): Throwable = t
    }
}