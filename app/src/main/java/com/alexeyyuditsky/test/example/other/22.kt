package com.alexeyyuditsky.test.example.other

import kotlin.random.Random
import kotlin.system.measureNanoTime

class GeoItem(
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val flag: Boolean
) {
    override fun toString(): String {
        return "$id $flag"
    }
}

val nonSortedList = List(5000) { index ->
    GeoItem(
        id = index.toLong(),
        latitude = Random.nextDouble(),
        longitude = Random.nextDouble(),
        flag = Random.nextBoolean()
    )
}

val sortedList = nonSortedList.sortedBy { it.flag }

fun binarySearchSplit(sortedList: List<GeoItem>): Int {
    var left = 0
    var right = sortedList.size

    while (left < right) {
        val mid = left + (right - left) / 2
        if (sortedList[mid].flag) {
            right = mid // Сужаем границу справа
        } else {
            left = mid + 1 // Сужаем границу слева
        }
    }
    return left // Индекс первого элемента с flag == true
}

fun main() {
    println(
        measureNanoTime {
            val splitIndex = binarySearchSplit(sortedList)
            val falseList = sortedList.subList(0, splitIndex)
            val trueList = sortedList.subList(splitIndex, sortedList.size)
            println("False List Size: ${falseList.size}")
            println("True List Size: ${trueList.size}")
        }
    )
}