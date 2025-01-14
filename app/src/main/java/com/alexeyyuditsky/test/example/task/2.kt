package com.alexeyyuditsky.test.example.task

fun main() {
    val res = isValid("{[()]}")
    println(res)
}

fun isValid(s: String): Boolean {
    if (s.length < 2) return false

    val array = s.toCharArray()
    var indexFromBack = array.size

    array.forEachIndexed { index, _ ->
        if (index == indexFromBack--) return true

        val leftItem = array[index]
        val rightItem = array[indexFromBack]

        if (leftItem == '(' && rightItem == ')') {
            return@forEachIndexed
        } else if (leftItem == '[' && rightItem == ']') {
            return@forEachIndexed
        } else if (leftItem == '{' && rightItem == '}') {
            return@forEachIndexed
        } else {
            return false
        }
    }

    return true
}