package com.alexeyyuditsky.dagger.atm.core

interface Command {

    enum class Status {
        INVALID, HANDLED
    }

    fun handleInput(input: List<String>): Result

    class Result(val status: Status) {
        companion object {
            fun invalid(): Result = Result(Status.INVALID)
            fun handled(): Result = Result(Status.HANDLED)
        }
    }

}