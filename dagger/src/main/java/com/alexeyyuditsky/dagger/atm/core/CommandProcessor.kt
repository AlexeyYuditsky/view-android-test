package com.alexeyyuditsky.dagger.atm.core

import java.util.ArrayDeque
import java.util.Deque
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(
    firstCommandRouter: CommandRouter
) {
    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque<CommandRouter>().apply {
        push(firstCommandRouter)
    }

    fun process(input: String): Status {
        val result = commandRouterStack.peek()?.route(input)
            ?: Result.invalid()
        if (result.status == Status.INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty())
                Status.INPUT_COMPLETED
            else
                Status.HANDLED
        }

        result.nestedCommandRouter?.let {
            commandRouterStack.push(it)
        }
        return result.status
    }

}