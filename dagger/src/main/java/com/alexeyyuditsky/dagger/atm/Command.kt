package com.alexeyyuditsky.dagger.atm

import javax.inject.Inject

interface Command {

    enum class Status {
        INVALID, HANDLED
    }

    val key: String

    fun handleInput(input: List<String>): Result

    class Result(val status: Status) {
        companion object {
            fun invalid(): Result = Result(Status.INVALID)
            fun handled(): Result = Result(Status.HANDLED)
        }
    }

    class HelloWorld @Inject constructor() : Command {

        override val key = "hello"

        override fun handleInput(input: List<String>): Result =
            if (input.isEmpty()) {
                println("world!")
                Result.handled()
            } else {
                Result.invalid()
            }

    }

}