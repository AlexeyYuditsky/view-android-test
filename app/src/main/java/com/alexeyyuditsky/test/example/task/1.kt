package com.alexeyyuditsky.test.example.task

fun main() {
    function(listOf(1, 2, 2))
}

fun function(list: List<Int>): Boolean {
    if (list.size < 2) return false

    for (index in 0..list.size - 2) {
        if (list[index] == list[index + 1]) return true
    }

    return false
}