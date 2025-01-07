package com.alexeyyuditsky.test.example.other

fun main() {
    Thread { println("hello ${Thread.currentThread().name}") }.run()
    Thread { println("hello ${Thread.currentThread().name}") }.start()
}