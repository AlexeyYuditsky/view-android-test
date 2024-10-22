package com.alexeyyuditsky.test.example.concurrency

object NoVisibility : Thread() {
    var ready = false
    var number = 0

    override fun run() {
        while (!ready) yield()
        println(number)
    }
}

fun main() {
    NoVisibility.start()
    NoVisibility.number = 42
    NoVisibility.ready = true
}