package com.alexeyyuditsky.test.example

import java.util.concurrent.Semaphore

var counter2 = 0
val semaphore = Semaphore(2)

fun increment() {
    try {
        semaphore.acquire()
        println("Value: ${++counter2}, Thread: ${Thread.currentThread().name}")
    } finally {
        semaphore.release()
    }
}

fun main() {
    val threads = List(1000) {
        Thread {
            for (i in 0 until 1000) {
                increment()
            }
        }
    }

    threads.forEach { it.start() }
    threads.forEach { it.join() }

    println("Final counter value: $counter2")
}