package com.alexeyyuditsky.test.example.other

class C(val test: Int)
data class D(val test: Int)

fun main() {
    val c1 = C(0)
    val c2 = C(0)
    println(c1 == c2)

    val d1 = D(0)
    val d2 = D(0)
    println(d1 == d2)
}