package com.alexeyyuditsky.test.example.dagger

interface Command {

    val key: String

    fun handleInput(input: List<String>): Result

    class Result(val status: Status) {
        companion object {
            fun invalid(): Result = Result(Status.INVALID)
            fun handled(): Result = Result(Status.HANDLED)
        }
    }

    enum class Status {
        INVALID, HANDLED
    }

}