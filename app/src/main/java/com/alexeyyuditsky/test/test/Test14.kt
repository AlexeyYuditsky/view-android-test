package com.alexeyyuditsky.test.test

fun main() {
    val res: Number = Test14().sum(2_000_000_000, 2_000_000_000)
    println(res.toString())
}

class Test14 {
    fun sum(a: Int, b: Int): Number {
        val c = Int.MAX_VALUE - a
        val d = Int.MIN_VALUE + a
        val res: Number = if (b >= c || b <= d) {
            a.toLong().plus(b)
        } else {
            a + b
        }

        return res
    }
}