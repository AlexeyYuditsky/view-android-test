package com.alexeyyuditsky.test.example

class Box<out T>(val value: T)

fun main() {
    val numberBox: Box<Int> = Box(3)
    val intBox: Box<Number> = numberBox
}