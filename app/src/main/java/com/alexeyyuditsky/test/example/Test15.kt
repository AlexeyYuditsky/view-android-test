package com.alexeyyuditsky.test.example

import java.util.concurrent.ThreadLocalRandom
import kotlin.streams.toList

fun main() {
    val originalRandom = java.util.Random().ints(10).toList()
    val randomLocal = ThreadLocalRandom.current().ints(10).toList()
    println(originalRandom)
    println(randomLocal)
}