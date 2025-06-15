package com.alexeyyuditsky.dagger.atm.core

import com.alexeyyuditsky.dagger.atm.di.UserCommandsRouter
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
) : Command {

    override fun handleInput(input: List<String>): Result {
        val username = input.firstOrNull()
            ?: return Result.invalid()
        val account = database.getAccount(username)
        outputter.output("$username is logged in with balance: ${account.balance}" )
        val commandRouter = userCommandsRouterFactory.create(account).router()
        return Result.enterNestedCommandSet(commandRouter)
    }

}