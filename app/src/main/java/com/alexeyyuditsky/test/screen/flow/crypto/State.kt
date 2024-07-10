package com.alexeyyuditsky.test.screen.flow.crypto

sealed class State {
    data object Loading : State()
    data class Content(val currencyList: List<Currency>) : State()
}