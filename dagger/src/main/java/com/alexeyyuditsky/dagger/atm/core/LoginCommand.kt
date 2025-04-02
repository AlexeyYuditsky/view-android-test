package com.alexeyyuditsky.dagger.atm.core

import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outputter: Outputter
) : Command {

    override fun handleInput(input: List<String>): Command.Result {
        val username = input.firstOrNull() ?: return Command.Result.invalid()
        outputter.output("$username is logged in")
        return Command.Result.handled()
    }

}