package com.alexeyyuditsky.test.recycler.model

sealed interface CarUi {

    class Base(
        val name: String,
        val speed: String,
        val hp: String
    ) : CarUi

    data object Empty : CarUi
}