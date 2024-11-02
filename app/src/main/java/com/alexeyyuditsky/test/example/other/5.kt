package com.alexeyyuditsky.test.example.other

import kotlin.reflect.KClass

fun main() {
    test(::aaa)
    test(B(2, 3)::aaa)
    val constructor = ::B
    constructor(1, 2)
    test5(5)
}

fun <T : Number> test5(t: T) {
    val res: KClass<out T> = t::class
    val res2: Class<out T> = t::class.java
    println(res)
    println(res2)
}

fun aaa(a: Int): Int {
    return a * a
}

class B(
    val a: Int,
    val b: Int
) {
    fun aaa(a: Int): Int {
        return a * a
    }
}

fun test(lamb: (Int) -> Int): Int {
    return lamb(2)
}