package com.alexeyyuditsky.dagger.atm.core

import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database
) : Command {

    override fun handleInput(input: List<String>): Result {
        if (input.size != 2)
            return Result.invalid()
        val username = input.first()
        val account = database.getAccount(username)
        val deposit = input[1].toLongOrNull()
            ?: return Result.invalid()
        account.deposit(deposit)
        outputter.output("$username is logged in with balance: ${account.balance}")
        return Result.handled()
    }

}