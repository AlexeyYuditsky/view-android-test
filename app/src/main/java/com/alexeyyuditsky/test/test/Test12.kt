package com.alexeyyuditsky.test.test

import java.util.Calendar

data class Day(
    val value: String,
    val isExtra: Boolean = false,
    val isClicked: Boolean = false
)

fun main() {
    val actualCalendar = Calendar.getInstance()

    val prevYearMonthList = getDataList(actualCalendar.get(Calendar.YEAR) - 1)
    val currentYearMonthList = getDataList(actualCalendar.get(Calendar.YEAR))
    val nextYearMonthList = getDataList(actualCalendar.get(Calendar.YEAR) + 1)

    val finalList = prevYearMonthList + currentYearMonthList + nextYearMonthList
    println(currentYearMonthList[4].map { it.value })
    println(finalList[19].map { it.value })
}

fun getDataList(year: Int): List<List<Day>> {
    return (0..11).map { month ->
        getListDays(month, year)
    }
}

fun check(calendar: Calendar, countLastMonthDays: Int): List<Day> {
    calendar.add(Calendar.MONTH, -1)
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))

    val lastDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

    val count = when (countLastMonthDays) {
        Calendar.MONDAY -> 0
        Calendar.TUESDAY -> 1
        Calendar.WEDNESDAY -> 2
        Calendar.THURSDAY -> 3
        Calendar.FRIDAY -> 4
        Calendar.SATURDAY -> 5
        else -> 6
    }

    val prevMonthList = (count downTo 1).map {
        Day((lastDayOfMonth - it + 1).toString())
    }

    return prevMonthList
}

fun getListDays(month: Int, year: Int): List<Day> {
    val countItem = 42

    val calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_MONTH, 1)

    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

    val prevMonthList = check(calendar, dayOfWeek)

    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_MONTH, 1)

    val currentMonthList = mutableListOf<Day>()
    for (day in 1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
        currentMonthList.add(Day(day.toString()))
    }

    val prevAndCurrentMonthList = prevMonthList + currentMonthList

    val nextMonthList = if (prevAndCurrentMonthList.size == countItem) {
        emptyList()
    } else {
        List(countItem - prevAndCurrentMonthList.size) { Day((it + 1).toString()) }
    }

    return prevAndCurrentMonthList + nextMonthList
}
