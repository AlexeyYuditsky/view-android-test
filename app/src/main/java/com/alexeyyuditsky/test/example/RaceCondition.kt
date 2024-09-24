package com.alexeyyuditsky.test.example

import kotlin.concurrent.thread

var counter = 0

fun main() {
    val threads = List(100) {
        thread {
            repeat(100) {
                counter++
            }
        }
    }

    threads.forEach { it.join() }
    println("Значение счетчика: $counter")
}