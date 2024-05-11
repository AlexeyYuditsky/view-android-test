package com.alexeyyuditsky.test.test

fun main() {
    val regex = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
    println("01/04/2026".matches(regex))
}