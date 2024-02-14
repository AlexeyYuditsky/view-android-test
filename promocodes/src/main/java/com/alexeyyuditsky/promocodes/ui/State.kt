package com.alexeyyuditsky.promocodes.ui

sealed interface State {
    data object Loading : State
    data class Error(val text: String) : State
    data class Next(val promocode: String) : State
}