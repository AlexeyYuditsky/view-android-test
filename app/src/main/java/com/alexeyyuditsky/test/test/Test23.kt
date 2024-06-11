package com.alexeyyuditsky.test.test

class Car1(
    val a: String,
    val b: Int
)

fun main() {
    val text = listOf(
        Car1("до 05:00", 5),
        Car1("до 04:00", 4),
        Car1("до 02:00", 2),
        Car1("до 01:00", 1)
    )
    val res = text.associateBy { it.b }

    println(res)
}