package com.alexeyyuditsky.test.example

// [-2, 1, 4] -> [1, 4, 16]
fun main() {
    val startValues = intArrayOf(-2, 1, 4)
    val finishValues = getSquareValues(startValues)
    finishValues.forEach {
        println(it)
    }
}

fun getSquareValues(array: IntArray): IntArray {
    val newArray = IntArray(array.size)

    array.forEach {
        val square = it * it
        
    }

    return newArray
}