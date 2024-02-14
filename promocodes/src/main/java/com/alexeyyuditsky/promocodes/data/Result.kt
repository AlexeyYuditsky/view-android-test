package com.alexeyyuditsky.promocodes.data

sealed interface Result {
    data class Success(val data: List<String>?) : Result
    data class Error(val throwable: Exception) : Result
}