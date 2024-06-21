package com.alexeyyuditsky.test.screen.lifecycle.calendar.model

data class Month(
    val position: Int,
    val name: String,
    val isSelected: Boolean = false
)