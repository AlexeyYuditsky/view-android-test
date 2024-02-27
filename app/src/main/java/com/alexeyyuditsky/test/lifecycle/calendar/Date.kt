package com.alexeyyuditsky.test.lifecycle.calendar

data class Date(
    val value: String,
    val isAdditional: Boolean,
    var isSelected: Boolean = false
)