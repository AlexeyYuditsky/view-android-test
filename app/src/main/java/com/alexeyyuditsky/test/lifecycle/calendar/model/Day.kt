package com.alexeyyuditsky.test.lifecycle.calendar.model

data class Day(
    val name: String,
    val isAdditional: Boolean = false,
    var isSelected: Boolean = false
)