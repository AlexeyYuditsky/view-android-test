package com.alexeyyuditsky.test.test

// [-1, 2, 4] -> [4, 9, 16]
fun main() {
    val startValues = intArrayOf(-1, 2, 14)
    val finishValues = getSquareValues(startValues)
    finishValues.forEach {
        println(it)
    }
}

fun getSquareValues(array: IntArray): IntArray {
    var a = array[0] * array[0]
    var b = array[2] * array[2]
    var c = array[1]
    if (a > b) {
        array[2] = a
        array[1] = b
    } else {
        array[2] = b
        array[1] = a
    }
    array[0] = c

    return array
}