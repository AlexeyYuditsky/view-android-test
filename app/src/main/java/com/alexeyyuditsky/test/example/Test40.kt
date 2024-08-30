package com.alexeyyuditsky.test.example

fun main() {

}

enum class Type {
    LOGOUT, // ...
}

sealed class Input(
    open val type: Type
) {

    data class Logout(
        override val type: Type
    ) : Input(type)

}