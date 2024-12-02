package com.alexeyyuditsky.test.example.other

var count = 0
val lock = Any()

fun main() {
    val threads = List(100_000) {
        Thread { test() }.apply { start() }
    }
    threads.forEach { it.join() }
    println(count)
}

fun test() {
    synchronized(lock) {
        count += 2
    }
}