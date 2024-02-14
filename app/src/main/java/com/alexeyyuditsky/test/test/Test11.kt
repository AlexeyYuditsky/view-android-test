package com.alexeyyuditsky.test.test

fun main() {
    val c = Computer()
    c.onFailure()
}

class Computer {
    fun onFailure() {
        println(javaClass.simpleName)
    }
}