package com.alexeyyuditsky.dagger.atm.core

import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database
) : Command {

    override fun handleInput(input: List<String>): Command.Result {
        val username = input.firstOrNull() ?: return Command.Result.invalid()
        val account = database.getAccount(username)
        outputter.output("$username is logged in with balance: ${account.balance}" )
        return Command.Result.handled()
    }

}