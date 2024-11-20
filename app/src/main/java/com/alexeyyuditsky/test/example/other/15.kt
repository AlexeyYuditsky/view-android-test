package com.alexeyyuditsky.test.example.other

fun main() {
    val time = System.currentTimeMillis()
    Thread.sleep(5000)
    val endTime =  System.currentTimeMillis()
    println(endTime - time)
}