package com.alexeyyuditsky.test.example

fun main() {
    val list = listOf("111", "222")
    val text = list.joinToString("','", "'", "'")
    println(text)
}