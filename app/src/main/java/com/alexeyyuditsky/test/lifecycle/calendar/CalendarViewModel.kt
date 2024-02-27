package com.alexeyyuditsky.test.lifecycle.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar

class CalendarViewModel : ViewModel() {

    /*class State(
        val month: List<String>,
        val year: Str
    )*/

    private val _dateLiveData = MutableLiveData<List<Date>>()
    val dateLiveData: LiveData<List<Date>> get() = _dateLiveData


    /*
    * spinner
    * year
    * days
    * select
    * cancel
    * */

    init {
        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentYear = calendar.get(Calendar.YEAR)
        getDateList(currentMonth, currentYear)
    }

    fun getDateList(month: Int, year: Int) {
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

        val currentMonthOfYear = Calendar.getInstance().get(Calendar.MONTH)
        val currentDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        val currentMonthList = (1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            .map { numberOfMonth ->
                Date(
                    value = numberOfMonth.toString(),
                    isAdditional = false,
                    isSelected = currentMonthOfYear == month && currentDayOfMonth == numberOfMonth
                )
            }

        if (month == 0) {
            calendar.set(Calendar.MONTH, 12)
            calendar.set(Calendar.YEAR, year - 1)
        } else {
            calendar.set(Calendar.MONTH, month - 1)
            calendar.set(Calendar.YEAR, year)
        }

        val maxDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val previousMonthList = (maxDayMonth + 1 - needCountDaysFromPreviousMonth..maxDayMonth)
            .map { Date(value = it.toString(), isAdditional = true) }

        val newDateList = dayList + previousMonthList + currentMonthList

        _dateLiveData.value = if (newDateList.size % DAY_OF_WEEK == 0) {
            newDateList
        } else {
            val nextMothList = (1..(DAY_OF_WEEK - (newDateList.size % DAY_OF_WEEK)))
                .map { Date(value = it.toString(), isAdditional = true) }
            newDateList + nextMothList
        }
    }

    fun getCurrentMonth(): Int {
        return Calendar.getInstance().get(Calendar.MONTH)
    }

    private companion object {
        const val DAY_OF_WEEK = 7
        val dayList = listOf(
            Date(value = "пн", isAdditional = false),
            Date(value = "вт", isAdditional = false),
            Date(value = "ср", isAdditional = false),
            Date(value = "чт", isAdditional = false),
            Date(value = "пт", isAdditional = false),
            Date(value = "сб", isAdditional = false),
            Date(value = "вс", isAdditional = false)
        )
    }
}