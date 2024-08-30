package com.alexeyyuditsky.test.example

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

suspend fun main() {
    val ioDispatcher = Dispatchers.IO
    val test36 = Test36(ioDispatcher)
    test36.test()
    println("thread: ${Thread.currentThread().name}")
}

class Test36(
    private val ioDispatcher: CoroutineDispatcher
) {
    private val mutex = Mutex()

    suspend fun test(): Boolean {
        mutex.withLock {
            withContext(ioDispatcher) {
                repeat(100) {
                    println("hello $it; thread: ${Thread.currentThread().name}")
                }
            }
        }

        return true
    }
}