package com.alexeyyuditsky.dagger.atm.core

import javax.inject.Inject

class CommandRouter @Inject constructor(
    private val commands: Map<String, Command>
) {

    fun route(input: String): Result {
        val splitInput = split(input)
        val commandName = splitInput.firstOrNull()
            ?: return invalidCommand(input)
        val command = commands[commandName]
            ?: return invalidCommand(input)

        val args = splitInput.drop(1)
        return command.handleInput(args)
            .takeIf { it.status != Status.INVALID }
            ?: invalidCommand(input)
    }

    private fun invalidCommand(input: String): Result {
        println("couldn't understand \"$input\". please try again.")
        return Result.invalid()
    }

    private fun split(input: String): List<String> =
        input
            .trim()
            .split("\\s+".toRegex())
            .filter { it.isNotBlank() }

}