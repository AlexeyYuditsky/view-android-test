package com.alexeyyuditsky.test.example.other

fun main() {
    callFunction(5) { println("Hello") }
}

inline fun callFunction(test: Int, noinline action: () -> Unit) {
    val kFunction = action::class
    println(kFunction)
}