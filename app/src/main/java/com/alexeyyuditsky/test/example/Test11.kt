package com.alexeyyuditsky.test.example

import java.util.Calendar

fun main() {
    val month = 2
    val year = 2024
    println(com.alexeyyuditsky.test.example.getDateList(month, year))
}

fun getDateList(month: Int, year: Int): List<String> {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.YEAR, year)

    val needCountDaysFromPreviousMonth = when (calendar[Calendar.DAY_OF_WEEK]) {
        Calendar.MONDAY -> 0
        Calendar.TUESDAY -> 1
        Calendar.WEDNESDAY -> 2
        Calendar.THURSDAY -> 3
        Calendar.FRIDAY -> 4
        Calendar.SATURDAY -> 5
        Calendar.SUNDAY -> 6
        else -> throw IllegalArgumentException("Invalid day")
    }

    val currentMonthList = (1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        .map { it.toString() }

    if (month == 0) {
        calendar.set(Calendar.MONTH, 12)
        calendar.set(Calendar.YEAR, year - 1)
    } else {
        calendar.set(Calendar.MONTH, month - 1)
        calendar.set(Calendar.YEAR, year)
    }

    val maxDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val previousMonthList = (maxDayMonth + 1 - needCountDaysFromPreviousMonth..maxDayMonth)
        .map { it.toString() }

    val dayList = listOf("пн", "вт", "ср", "чт", "пт", "сб", "вс")
    return dayList + previousMonthList + currentMonthList
}