package com.alexeyyuditsky.test.test

fun main() {
    val list = listOf("111", "222")
    val text = list.joinToString("','", "'", "'")
    println(text)
}