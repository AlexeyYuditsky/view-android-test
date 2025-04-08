package com.alexeyyuditsky.dagger.atm.core

import javax.inject.Inject

class HelloWorldCommand @Inject constructor(
    private val outputter: Outputter
) : Command {

    override fun handleInput(input: List<String>): Result =
        if (input.isEmpty()) {
            outputter.output("world!")
            Result.handled()
        } else {
            Result.invalid()
        }

}