package com.alexeyyuditsky.test.screen.lifecycle.calendar.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.screen.lifecycle.calendar.model.Day
import com.alexeyyuditsky.test.screen.lifecycle.calendar.model.Month
import java.util.Calendar

class CalendarViewModel : ViewModel() {

    private val _monthListLiveData = MutableLiveData<List<Month>>()
    val monthListLiveData: LiveData<List<Month>> get() = _monthListLiveData

    private val _yearLiveData = MutableLiveData<Int>()
    val yearLiveData: LiveData<Int> get() = _yearLiveData

    private val _dayListLiveData = MutableLiveData<List<Day>>()
    val dayListLiveData: LiveData<List<Day>> get() = _dayListLiveData

    private val _selectButtonDateLiveData = MutableLiveData<String>()
    val selectButtonDateLiveData: LiveData<String> get() = _selectButtonDateLiveData

    private val _selectButtonStateLiveData = MutableLiveData<Boolean>()
    val selectButtonStateLiveData: LiveData<Boolean> get() = _selectButtonStateLiveData

    private val actualCalendar = Calendar.getInstance()

    init {
        updateMonthList()
        updateYear()
        updateDayList()
    }

    fun changeButtonState(isActive: Boolean) {
        _selectButtonStateLiveData.value = isActive
    }

    fun sendDate() {
        val date = buildString {
            append(DATE_FORMAT.format(dayListLiveData.value!!.find { it.isSelected }!!.name.toInt()))
            append(SEPARATOR)
            append(DATE_FORMAT.format(monthListLiveData.value!!.find { it.isSelected }!!.position + 1))
            append(SEPARATOR)
            append(yearLiveData.value.toString().takeLast(2))
        }

        _selectButtonDateLiveData.value = date
    }

    fun updateMonthList(monthPosition: Int = NO_SELECTION) {
        val currentMonth = if (monthPosition == NO_SELECTION)
            actualCalendar.get(Calendar.MONTH)
        else
            monthPosition

        _monthListLiveData.value = monthList.map { month ->
            if (currentMonth == month.position)
                month.copy(isSelected = true)
            else
                month
        }
    }

    fun updateDayList() {
        val calendar = Calendar.getInstance()
        val selectedMonth = monthListLiveData.value!!.indexOfFirst { it.isSelected }
        val selectedYear = yearLiveData.value!!
        calendar.set(Calendar.MONTH, selectedMonth)
        calendar.set(Calendar.YEAR, selectedYear)

        val currentDayOfWeek = calendar[Calendar.DAY_OF_WEEK]

        calendar.set(Calendar.MONTH, selectedMonth - 1)

        val lastDayLastMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayListLastMonth = (lastDayLastMonth - (currentDayOfWeek - 2)..lastDayLastMonth)
            .map { number ->
                Day(
                    name = number.toString(),
                    isAdditional = true
                )
            }

        calendar.set(Calendar.MONTH, selectedMonth)

        val isInCurrentMonth = monthListLiveData.value!!.indexOfFirst { it.isSelected } ==
                actualCalendar.get(Calendar.MONTH) &&
                yearLiveData.value!! ==
                actualCalendar.get(Calendar.YEAR)

        changeButtonState(isInCurrentMonth)

        val today = calendar.get(Calendar.DAY_OF_MONTH)
        val currentMonthList = (1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            .map { dayOfMonth ->
                Day(
                    name = dayOfMonth.toString(),
                    isSelected = if (isInCurrentMonth)
                        dayOfMonth == today
                    else
                        false
                )
            }

        val allDayList = dayList + dayListLastMonth + currentMonthList

        _dayListLiveData.value = if (allDayList.size % DAY_OF_WEEK == 0) {
            allDayList
        } else {
            allDayList + (1..(DAY_OF_WEEK - (allDayList.size % DAY_OF_WEEK)))
                .map { numberOfMonth ->
                    Day(
                        name = numberOfMonth.toString(),
                        isAdditional = true
                    )
                }
        }
    }

    private fun updateYear() {
        _yearLiveData.value = actualCalendar.get(Calendar.YEAR)
    }

    fun backMonth() {
        val positionCurrentMonth = monthListLiveData.value!!.indexOfFirst { it.isSelected }
        if (positionCurrentMonth == FIRST_MONTH) {
            if (yearLiveData.value!! - 1 < actualCalendar.get(Calendar.YEAR) - 1) return
            updateMonthList(LAST_MONTH)
            _yearLiveData.value = yearLiveData.value!! - 1
        } else {
            updateMonthList(positionCurrentMonth - 1)
        }
    }

    fun nextMonth() {
        val positionCurrentMonth = monthListLiveData.value!!.indexOfFirst { it.isSelected }
        if (positionCurrentMonth == LAST_MONTH) {
            if (yearLiveData.value!! + 1 > actualCalendar.get(Calendar.YEAR) + 1) return
            updateMonthList(FIRST_MONTH)
            _yearLiveData.value = yearLiveData.value!! + 1
        } else {
            updateMonthList(positionCurrentMonth + 1)
        }
    }

    fun backYear() {
        if (yearLiveData.value!! - 1 < actualCalendar.get(Calendar.YEAR) - 1) return
        _yearLiveData.value = yearLiveData.value!! - 1
        updateDayList()
    }

    fun nextYear() {
        if (yearLiveData.value!! + 1 > actualCalendar.get(Calendar.YEAR) + 1) return
        _yearLiveData.value = yearLiveData.value!! + 1
        updateDayList()
    }

    fun updateDayListByPosition(position: Int) {
        val date = _dayListLiveData.value!![position]
        if (date.isSelected || date.isAdditional || date.name.toIntOrNull() == null) return

        _dayListLiveData.value = dayListLiveData.value!!.mapIndexed { index, item ->
            if (index == position) {
                item.copy(isSelected = true)
            } else if (item.isSelected) {
                item.copy(isSelected = false)
            } else {
                item
            }
        }
    }

    private companion object {
        const val NO_SELECTION = -1
        const val FIRST_MONTH = 0
        const val DAY_OF_WEEK = 7
        const val LAST_MONTH = 11
        const val DATE_FORMAT = "%02d"
        const val SEPARATOR = "."

        val dayList = listOf(
            Day(name = "пн"),
            Day(name = "вт"),
            Day(name = "ср"),
            Day(name = "чт"),
            Day(name = "пт"),
            Day(name = "сб"),
            Day(name = "вс")
        )

        val monthList = listOf(
            Month(position = 0, name = "Январь"),
            Month(position = 1, name = "Февраль"),
            Month(position = 2, name = "Март"),
            Month(position = 3, name = "Апрель"),
            Month(position = 4, name = "Май"),
            Month(position = 5, name = "Июнь"),
            Month(position = 6, name = "Июль"),
            Month(position = 7, name = "Август"),
            Month(position = 8, name = "Сентябрь"),
            Month(position = 9, name = "Октябрь"),
            Month(position = 10, name = "Ноябрь"),
            Month(position = 11, name = "Декабрь")
        )
    }
}