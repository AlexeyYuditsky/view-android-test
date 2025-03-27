package com.alexeyyuditsky.dagger.atm

import javax.inject.Inject

class CommandRouter @Inject constructor(
    command: Command
) {

    private val commands = mapOf<String, Command>(
        command.key to command
    )

    fun route(input: String): Command.Result {
        val splitInput = split(input)
        val commandName = splitInput.firstOrNull() ?: return invalidCommand(input)
        val command = commands[commandName] ?: return invalidCommand(input)

        val args = splitInput.drop(1)
        return command.handleInput(args)
            .takeIf { it.status != Command.Status.INVALID }
            ?: invalidCommand(input)
    }

    private fun invalidCommand(input: String): Command.Result {
        println("couldn't understand \"$input\". please try again.")
        return Command.Result.invalid()
    }

    private fun split(input: String): List<String> =
        input
            .trim()
            .split("\\s+".toRegex())
            .filter { it.isNotBlank() }

}