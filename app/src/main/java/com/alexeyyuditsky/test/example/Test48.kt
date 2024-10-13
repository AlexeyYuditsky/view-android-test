package com.alexeyyuditsky.test.example

import kotlin.system.measureTimeMillis

var counter2 = 0
val lock = Any()

fun increment() {
    synchronized(lock) {
        counter2++
    }
    println("Counter incremented to $counter2 by ${Thread.currentThread().name}")
}

fun main() {
    val threads = List(1000) {
        Thread {
            for (i in 0 until 1000) {
                increment()
            }
        }
    }

    val time = measureTimeMillis {
        threads.forEach { it.start() }
        threads.forEach { it.join() }
    }
    println(time)

    println("Final counter value: $counter2")
}